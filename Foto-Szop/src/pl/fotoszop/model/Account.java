package pl.fotoszop.model;


import java.sql.Date;
import java.time.LocalDate;

import pl.fotoszop.modelinterfaces.IAccount;


public class Account implements IAccount{
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", login=" + login + ", password=" + password + ", creationDate="
				+ creationDate + ", clientId=" + clientId + "]";
	}
	private int accountId;
	private String login;
	private String password;
	private Date creationDate;
	private int clientId;
	
	public Account(){
		
	}
	
	public Account (Form form){
		accountId = form.getId();
		login = form.getEmail();
		password = form.getPassword();
		creationDate = Date.valueOf(LocalDate.now());
		clientId = form.getId();
	}
	
	public int getClientId(){
		return clientId;
	}
	public void setClientId(int id){
		clientId = id;
	}
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
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
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	

}
