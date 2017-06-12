package pl.fotoszop.DAODbImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.fotoszop.dao.EmployeeDAO;
import pl.fotoszop.dto.AddEmpDTO;
import pl.fotoszop.model.Client;
import pl.fotoszop.model.Employee;
import pl.fotoszop.model.Manager;
import pl.fotoszop.modelinterfaces.IClient;
import pl.fotoszop.modelinterfaces.IEmployee;



@Repository
public class EmployeeDAODbImpl implements EmployeeDAO
{
	private static final Logger logger = Logger.getLogger(EmployeeDAODbImpl.class.getName());
    private JdbcTemplate jdbcTemplate;


    public void setDataSource(DataSource dataSource)
	{

        this.jdbcTemplate = new JdbcTemplate(dataSource);
        logger.info("Connected with database");
    }
    
    public int save(Employee emp){
    	
    	String sqlQuery = "insert into employee (id_employee,name,surname,personal_id,phone_nr,email) values (?,?,?,?,?,?)";
    	jdbcTemplate.update(sqlQuery, emp.getId(), emp.getName(), emp.getSurname(),emp.getIdentityNumber(), 
    						emp.getPhoneNumber(), emp.getEmail());

        logger.info(emp.getEmail() + "has been added or updated");
        return 0;
    }

    @Override
    public IEmployee getEmployeeById(long employeeId) {

        String sqlQuery = "select * from employee where employee.id_employee = ? ";

        Employee employee = this.jdbcTemplate.queryForObject(sqlQuery, new Object[]{employeeId}, new EmployeeMapper());
		logger.info("Getting employeee with id: " + employeeId);
        return employee;

	}
	
	@Override 
	public Manager getManagerById(long employeeId){
		
		Manager manager = null;
		String sqlQuery = "select employee.id_employee, employee.name, employee.surname, employee.personal_id, employee.phone_nr, employee.email "
				+ "from employee join employee_type_employee on employee.id_employee=employee_type_employee.id_employee "
				+ "where employee_type_employee.id_employee = ? and employee_type_employee.id_type=1";
		try{
		manager = this.jdbcTemplate.queryForObject(sqlQuery, new Object[] {employeeId}, new ManagerMapper());
		logger.info("Manager with id: " + employeeId + " has been taken");
		}
		catch(EmptyResultDataAccessException erdae){
			logger.warning("Cannot take manager with id: " + employeeId);
			manager = null;
		}

		return manager;
	}
	
	
	    public Collection<IEmployee> getAllEmployee() {
	        String sqlQuery = "select * from employee";
	        Collection<Employee> employees = this.jdbcTemplate.query(sqlQuery, new EmployeeMapper());

	        logger.info("All contact has been taken from the database");
	        return employees.stream().map(x -> (IEmployee) x).collect(Collectors.toList());
	    }
	
	public boolean checkToAddEmp(AddEmpDTO empForm){
		
		Collection<IEmployee> emps = new ArrayList<>();
        emps = getAllEmployee();
        boolean isTaken = false;

        long id = 0;

        for (IEmployee object : emps) {
            if (object.getEmail().equals(empForm.getEmail()))
                isTaken = true;
            if (object.getId() > empForm.getId()) id = object.getId();
        }

        id++;
        empForm.setId(id);
        return isTaken;
		
	}

}
