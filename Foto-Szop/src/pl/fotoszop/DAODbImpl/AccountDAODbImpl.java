package pl.fotoszop.DAODbImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
