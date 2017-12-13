package pl.fotoszop.modelinterfaces;

import pl.fotoszop.model.PersonType;

public interface IPerson {
	PersonType getType();
	
    long getPersonId();

    void setPersonId(long id);

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
    
    void setAddress(String address);

    String getAddress();
}
