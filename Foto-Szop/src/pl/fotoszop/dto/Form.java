package pl.fotoszop.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import pl.fotoszop.model.HashGenerator;

import javax.validation.constraints.Size;

public class Form {


    // REGISTER //

    private int id;
    @NotEmpty
    @Size(min = 2, max = 20)
    private String name;
    @NotEmpty
    @Size(min = 2, max = 20)
    private String surname;
    @NotEmpty
    @Size(min = 6)
    private String address;
    @NotEmpty
    @Size(min = 11, max = 11)
    private String identityNumber;
    @NotEmpty
    @Size(min = 9, max = 9)
    private String phoneNumber;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String password;
    @NotEmpty
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
     *
     * @return true - if passwords given in form are the same,  false - if they are not the same
     */
    public boolean checkPasswords() {

        if (password.equals(password2))
            return true;

        return false;

    }

    /**
     * Method to change plaintext password to hash
     */
    public void doHash() {

        password = HashGenerator.doHash(password);
        password2 = HashGenerator.doHash(password2);
    }


}
