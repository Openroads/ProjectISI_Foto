package pl.fotoszop.DAODbImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.format.datetime.DateTimeFormatAnnotationFormatterFactory;
import org.springframework.format.datetime.joda.LocalDateParser;
import org.springframework.jdbc.core.JdbcTemplate;

import pl.fotoszop.dao.TermDAO;
import pl.fotoszop.dto.TermFormtDTO;
import pl.fotoszop.model.Account;
import pl.fotoszop.model.Term;
import pl.fotoszop.modelinterfaces.IEmployee;
import pl.fotoszop.modelinterfaces.ITerm;

public class TermDAODbImpl implements TermDAO {
	
	private static final String SQL_GET_TERMS_EMPLOYEE = "Select id_term,date_of_term from term where id_employee = ? and date_of_term >= ?";
	private static final String SQL_GET_TERMS_FROM_DATE = "Select * from term where date_of_term >= ?";
	private static final String SQL_GET_LAST_ID = "select max(id_term) from term";
	private static final String INSERT_NEW_TERM = "insert into term(id_term, id_employee,date_of_term) VALUES(?,?,?)";
	private static final String SQL_DELETE_TERM_FOR_ID = "delete from term where term.id_term = ?";
	private static final String  SQL_GET_TERMS_BETWEEN_DATE = "Select * from term where date_of_term >= ? and date_of_term <= ?" ;
	
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
	
	@Override
	public List<ITerm> getFreeTermsForWeek(LocalDate date) {
		
		
		Connection connection = null;
		List<ITerm> termList = new ArrayList<ITerm>();
		
		try {
			connection = dataSource.getConnection();
			
			DayOfWeek dayOfweek = date.getDayOfWeek();
			
			
			int dayNumberDayOfWeek = dayOfweek.getValue();
			
			int dayUntilFinishWeek = 7 - dayNumberDayOfWeek;
			
			LocalDate sundayDate =  date.plusDays(dayUntilFinishWeek);
			
			PreparedStatement statement = connection.prepareStatement(SQL_GET_TERMS_BETWEEN_DATE);
			statement.setDate(1, java.sql.Date.valueOf(date));
			statement.setDate(2, java.sql.Date.valueOf(sundayDate));
			
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
	@Override
	public int addNewTerm(TermFormtDTO newTerm) {
		Connection connection = null;
		
		
		try {
			
			connection = dataSource.getConnection();
			
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(SQL_GET_LAST_ID);
			int id = 0;
			if(rs.next())
			{
				id = rs.getInt(1) +1; 
			}
			
			
			PreparedStatement prStatement = connection.prepareStatement(INSERT_NEW_TERM);
			prStatement.setInt(1, id);
			prStatement.setInt(2, newTerm.getEmployeeId());
			prStatement.setDate(3,new java.sql.Date((newTerm.getDate().getTime())));
			prStatement.executeUpdate();
		
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
			
		return 0;
	}

	@Override
	public boolean deleteTerm(int id) {
		
		Connection connection = null;
		
		
		try {
			
			connection = dataSource.getConnection();
			

			PreparedStatement statement = connection.prepareStatement(SQL_DELETE_TERM_FOR_ID);
			statement.setInt(1, id);
			statement.executeUpdate();
			
			return true;
			
		}catch (SQLException e) {
			//TODO TO LOGER 
			
			e.printStackTrace();
			return false;
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
		
			
	}
}
