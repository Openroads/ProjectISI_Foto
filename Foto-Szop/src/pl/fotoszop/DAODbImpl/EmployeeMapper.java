package pl.fotoszop.DAODbImpl;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;
import pl.fotoszop.model.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee emp = new Employee();
		emp.setId(rs.getInt("id_employee"));

		emp.setName(rs.getString("name"));
		emp.setSurname(rs.getString("surname"));
		emp.setIdentityNumber(rs.getString("personal_id"));
		emp.setPhoneNumber(rs.getString("phone_nr"));
		emp.setEmail(rs.getString("email"));

		return null;
	}



}
