package pl.fotoszop.modelinterfaces;

public interface IClient {
	
	public int getId();
	public void setId(int id);
	public void setName(String name);
	public void setSurname(String surname);
	public void setAddress(String address);
	public void setIdentityNumber(String identityNumber);
	public void setPhoneNumber(String phoneNumber);
	public void setEmail(String email);
	
	public String getName();
	public String getSurname();
	public String getAddress();
	public String getIdentityNumber();
	public String getPhoneNumber();
	public String getEmail();
	
}