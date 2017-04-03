package pl.fotoszop.model;

import pl.fotoszop.modelinterfaces.IClient;

public class Client implements IClient{
	
	private int id;
	private String name;
	private String surname;
	private String address;
	private String identityNumber;
	private String phoneNumber;
	private String email;
	
	public Client()
	{
		
	}
	
	public Client(int id, String name, String surname, String address, String identityNumber, String phoneNumber,
			String email) {

		this.id = id;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.identityNumber = identityNumber;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	
	
	
}
