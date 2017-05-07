package pl.fotoszop.modelinterfaces;

import java.sql.Date;

public interface IAccount {
	
	public int getAccountId();
	public void setAccountId(int accountId);
	public String getLogin();
	public void setLogin(String login);
	public String getPassword();
	public void setPassword(String password);
	public Date getCreationDate();
	public void setCreationDate(Date creationDate);

}
