package pl.fotoszop.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import pl.fotoszop.dao.AccountDAO;
import pl.fotoszop.model.HashGenerator;
import pl.fotoszop.modelinterfaces.IAccount;

public class LoginFormDTO {
	@NotEmpty
	@Email
	private String login;
	
	@NotEmpty
	private String password;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Method to change plaintext password to hash
	 */
	public void doHash(){
		
		password = HashGenerator.doHash(password);
		
	}
	
	/**
	 * Method to check if data from login form is correct
	 * @param database - storage which contains accounts info
	 * @return int result - 1 when succes, -1 when login doesnt exist, 0 when password is incorrect or another failure
	 */
	
	public int checkToLogin(AccountDAO database){
		
		IAccount account = null;
		account = database.getAccountByLogin(login);
		if(account==null)
			return -1;
		else 
		{
			if(account.getPassword().equals(password))
				return 1;
		}
		
		return 0;
	}
	
	public IAccount getAccount(AccountDAO database){
		
		if(this.checkToLogin(database)==1){
			IAccount account = database.getAccountByLogin(login);
			return account;
		}
		return null;
	}
	
}
