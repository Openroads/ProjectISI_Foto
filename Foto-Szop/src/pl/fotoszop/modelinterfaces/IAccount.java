package pl.fotoszop.modelinterfaces;

public interface IAccount {
	
	public int getAccountId();
	public void setAccountId(int accountId);
	public String getLogin();
	public void setLogin(String login);
	public String getPassword();
	public void setPassword(String password);
	public String getCreationDate();
	public void setCreationDate(String creationDate);

}
