package pl.fotoszop.DAODbImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;


import pl.fotoszop.dao.AccountDAO;
import pl.fotoszop.model.Account;
import pl.fotoszop.modelinterfaces.IAccount;

public class AccountDAODbImpl implements AccountDAO{
	
	private static final String SQL_GET_ACCOUNT_BY_LOGIN = "SELECT * from account where login = ? ";
	
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
		
	public int saveOrUpdate(IAccount account){
		
		Connection connection = null; 
		
		try {
			connection = dataSource.getConnection();
			String sqlQuery = "insert into account(id_account,login,password,date_of_creation,id_employee,id_client) "
					+ "values (?,?,?,?,NULL,?)";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setInt(1, account.getAccountId()); statement.setString(2, account.getLogin()); 
			statement.setString(3, account.getPassword());statement.setDate(4, account.getCreationDate()); 
			statement.setInt(5, account.getClientId()); 
			statement.executeUpdate();
		} catch (SQLException e) {
			
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
	
	public Collection<IAccount> getAllAccounts(int id){
		
		Connection connection = null;
		Collection<IAccount> accounts = null;
		IAccount account = new Account();
		try {
			connection=dataSource.getConnection();
			String sqlQuery = "SELECT * from Account";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sqlQuery);
			accounts = new ArrayList<>();
			while(rs.next()){
				account.setAccountId(rs.getInt("id_account")); account.setLogin(rs.getString("login"));
				account.setClientId(rs.getInt("id_client")); account.setCreationDate(rs.getDate("date_of_creation"));
				account.setPassword(rs.getString("password"));
				accounts.add(account);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return accounts;
	}
	
	@Override
	public IAccount getAccountByLogin(String login) {
		
		Connection connection = null;
				
		try {
			
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(SQL_GET_ACCOUNT_BY_LOGIN);
			statement.setString(1, login);
			ResultSet rs = statement.executeQuery();
			Account account = null;
			
			if(rs.next())
			{
				account = new Account();
				account.setAccountId(rs.getInt("id_account"));
				account.setLogin(rs.getString("login"));
				account.setPassword(rs.getString("password"));
				account.setCreationDate(rs.getDate("date_of_creation"));
			}
			statement.close();
			rs.close();
			return account;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		
		return null;
	}

}
