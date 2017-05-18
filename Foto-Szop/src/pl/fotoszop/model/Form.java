package pl.fotoszop.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import pl.fotoszop.dao.ClientDAO;
import pl.fotoszop.modelinterfaces.IClient;

public class Form {

	private int id;
	private String name;
	private String surname;
	private String address;
	private String identityNumber;
	private String phoneNumber;
	private String email;
	private String password;
	private String password2;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
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
	
	
	
	/**
	 * Method to check if user gave password and password 2 properly
	 * @return true - if passwords given in form are the same,  false - if they are not the same
	 */
	public boolean checkPasswords(){
		
		if(password.equals(password2))
			return true;
		
		return false;
		
	}
	
	/**
	 * Method to change plaintext password to hash
	 */
	public void doHash(){
		
		password = HashGenerator.doHash(password);
		password2 = HashGenerator.doHash(password2);
	}
	
	
}
