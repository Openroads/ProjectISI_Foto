package pl.fotoszop.dto;

import org.hibernate.validator.constraints.NotEmpty;

import pl.fotoszop.model.HashGenerator;

public class EditFormDTO {
	
	private String name;
	private String surname;
	private String address;
	private String phoneNumber;
	@NotEmpty
	private String password;
	private String newPassword;
	
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
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	/**
	 * Method to change plaintext password to hash
	 */
	public void doHash(){
		
		password = HashGenerator.doHash(password);
		
	}
	
	
}
