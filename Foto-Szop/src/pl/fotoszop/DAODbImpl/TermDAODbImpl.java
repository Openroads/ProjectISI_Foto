package pl.fotoszop.DAODbImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import pl.fotoszop.dao.TermDAO;
import pl.fotoszop.model.Account;
import pl.fotoszop.model.Term;
import pl.fotoszop.modelinterfaces.IEmployee;
import pl.fotoszop.modelinterfaces.ITerm;

public class TermDAODbImpl implements TermDAO {
	
	private static final String SQL_GET_TERMS_EMPLOYEE = "Select id_term,date_of_term from term where id_term= ? and date_of_term >= ?";
	private static final String SQL_GET_TERMS_FROM_DATE = "Select * from term where date_of_term >= ?";
	

	
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public List<ITerm> getCurrentTermsForEmployee(IEmployee employee) {
		Connection connection = null;
		List<ITerm> termList = new ArrayList<ITerm>();
		
		try {
			connection = dataSource.getConnection();
			
			PreparedStatement statement = connection.prepareStatement(SQL_GET_TERMS_EMPLOYEE);
			statement.setInt(1,(int)employee.getId());
			statement.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
			ResultSet rs = statement.executeQuery();
			ITerm term = null;
			
			while(rs.next())
			{
				term = new Term();
				term.setId(rs.getInt("id_term"));
				term.setIdEmployee((int)employee.getId());
				term.setDate(rs.getDate("date_of_term"));
				termList.add(term);
			}
		}catch (SQLException e) {
			//TODO TO LOGER 
			e.printStackTrace();
		}finally {
			if(connection != null)
			{
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return termList;
	}

	@Override
	public List<ITerm> getFreeTermsFromDate(LocalDate date) {
		
		Connection connection = null;
		List<ITerm> termList = new ArrayList<ITerm>();
		
		try {
			connection = dataSource.getConnection();
			
			PreparedStatement statement = connection.prepareStatement(SQL_GET_TERMS_FROM_DATE);
			statement.setDate(1, java.sql.Date.valueOf(date));
			ResultSet rs = statement.executeQuery();
			ITerm term = null;
			
			while(rs.next())
			{
				term = new Term();
				term.setId(rs.getInt("id_term"));
				term.setIdEmployee(rs.getInt("id_employee"));
				term.setDate(rs.getDate("date_of_term"));
				termList.add(term);
			}
		}catch (SQLException e) {
			//TODO TO LOGER 
			e.printStackTrace();
		}finally {
			if(connection != null)
			{
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return termList;
	}

}
