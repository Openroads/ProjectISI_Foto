package pl.fotoszop.modelinterfaces;

public interface IEmployee {
	
	public long getId();
	public void setId(long id);
	public void setName(String name);
	public void setSurname(String surname);
	public void setIdentityNumber(String identityNumber);
	public void setPhoneNumber(String phoneNumber);
	public void setEmail(String email);
	
	public String getName();
	public String getSurname();
	public String getIdentityNumber();
	public String getPhoneNumber();
	public String getEmail();
}
