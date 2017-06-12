package pl.fotoszop.DAODbImpl;

import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.fotoszop.dao.EmployeeDAO;
import pl.fotoszop.model.Employee;
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

    @Override
    public IEmployee getEmployeeById(long employeeId) {

        String sqlQuery = "select * from employee where employee.id_employee = ? ";

        Employee employee = this.jdbcTemplate.queryForObject(sqlQuery, new Object[]{employeeId}, new EmployeeMapper());
		logger.info("Getting employeee with id: " + employeeId);
        return employee;

	}
	
	@Override 
	public IEmployee getManagerById(long employeeId){
		
		Employee manager = null;
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

}
