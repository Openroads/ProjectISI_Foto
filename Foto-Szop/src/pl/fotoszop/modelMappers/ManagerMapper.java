package pl.fotoszop.modelMappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pl.fotoszop.model.Employee;
import pl.fotoszop.model.Manager;

public class ManagerMapper implements RowMapper<Manager> {

	@Override
	public Manager mapRow(ResultSet rs, int row) throws SQLException {

		Manager man = new Manager();
		
		man.setId(rs.getInt("id_employee"));
		man.setName(rs.getString("name"));
		man.setSurname(rs.getString("surname"));
		man.setIdentityNumber(rs.getString("personal_id"));
		man.setPhoneNumber(rs.getString("phone_nr"));
		man.setEmail(rs.getString("email"));

		return man;
		
	}

}
