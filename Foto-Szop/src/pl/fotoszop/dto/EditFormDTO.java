package pl.fotoszop.dto;

import org.hibernate.validator.constraints.NotEmpty;

import pl.fotoszop.model.HashGenerator;

public class EditFormDTO {
	
	private String address;
	private String phoneNumber;
	@NotEmpty
	private String password;
	private String passwordNew;
	private String passwordNew2;
	
	

	public String getPasswordNew() {
		return passwordNew;
	}
	public void setPasswordNew(String passwordNew) {
		this.passwordNew = passwordNew;
	}
	public String getPasswordNew2() {
		return passwordNew2;
	}
	public void setPasswordNew2(String passwordNew2) {
		this.passwordNew2 = passwordNew2;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	
	
}
