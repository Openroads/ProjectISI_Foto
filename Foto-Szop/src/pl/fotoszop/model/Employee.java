package pl.fotoszop.model;

import pl.fotoszop.dto.AddEmpDTO;
import pl.fotoszop.modelinterfaces.IEmployee;
import pl.fotoszop.modelinterfaces.IPerson;

public class Employee implements IEmployee,IPerson {

    protected long id;
    protected String name;
    protected String surname;
    protected String identityNumber;
    protected String phoneNumber;
    protected String email;

    
    public void setFromForm(AddEmpDTO empForm){
    	this.id = empForm.getId();
    	this.name = empForm.getName();
    	this.surname = empForm.getSurname();
    	this.identityNumber=empForm.getIdentityNumber();
    	this.phoneNumber=empForm.getPhoneNumber();
    	this.email=empForm.getEmail();
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	@Override
	public long getPersonId() {
		return getId();
	}

	@Override
	public void setPersonId(long id) {
		setId(id);
		
	}

	@Override
	public void setAddress(String address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getAddress() {
		return null;
	}

	@Override
	public PersonType getType() {
		return PersonType.EMP;
	}

}
