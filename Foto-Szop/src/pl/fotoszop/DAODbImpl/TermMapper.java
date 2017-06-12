package pl.fotoszop.DAODbImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pl.fotoszop.model.Term;

public class TermMapper implements RowMapper<Term>{

	@Override
	public Term mapRow(ResultSet rs, int rowNum) throws SQLException {
		Term term = new Term();
		term.setId(rs.getInt("id_term"));
		term.setIdEmployee(rs.getInt("id_employee"));
		term.setDate(rs.getDate("date_of_term"));
		return term;
	}

}
