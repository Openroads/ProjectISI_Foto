package pl.fotoszop.modelinterfaces;

public interface IEmployee extends IPerson {

    long getId();

    void setId(long id);

    String getName();

    void setName(String name);

    String getSurname();

    void setSurname(String surname);

    String getIdentityNumber();

    void setIdentityNumber(String identityNumber);

    String getPhoneNumber();

    void setPhoneNumber(String phoneNumber);

    String getEmail();

    void setEmail(String email);
}
