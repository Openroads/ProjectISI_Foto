package pl.fotoszop.modelinterfaces;

public interface IClient extends IPerson{

    public int getId();

    public void setId(int id);

    public String getName();

    public void setName(String name);

    public String getSurname();

    public void setSurname(String surname);

    public String getAddress();

    public void setAddress(String address);

    public String getIdentityNumber();

    public void setIdentityNumber(String identityNumber);

    public String getPhoneNumber();

    public void setPhoneNumber(String phoneNumber);

    public String getEmail();

    public void setEmail(String email);

}