package pl.fotoszop.DAODbImpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import pl.fotoszop.dao.EmployeeDAO;
import pl.fotoszop.model.Employee;
import pl.fotoszop.modelinterfaces.IEmployee;

public class EmployeeDAODbImpl implements EmployeeDAO {
	private JdbcTemplate jdbcTemplate;
	
	
	 public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }
	
	@Override
	public IEmployee getEmployeeById(long employeeId) {
		
		String sqlQuery = "select * from employee where employee.id_employee = ? ";
	
		Employee employee =  this.jdbcTemplate.queryForObject(sqlQuery, new Object[] { employeeId }, new EmployeeMapper());
		
		return employee;

	}

}
