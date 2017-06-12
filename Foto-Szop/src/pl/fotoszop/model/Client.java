package pl.fotoszop.model;

import pl.fotoszop.dto.Form;
import pl.fotoszop.modelinterfaces.IClient;

public class Client implements IClient {

    private int id;
    private String name;
    private String surname;
    private String address;
    private String identityNumber;
    private String phoneNumber;
    private String email;

    public Client() {

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

    /**
     * Constructor which mights be use to create a Client instance from instance of Form
     *
     * @param form - object that is created from input in html
     */
    public Client(Form form) {

        this.id = form.getId();
        this.name = form.getName();
        this.surname = form.getSurname();
        this.address = form.getAddress();
        this.identityNumber = form.getIdentityNumber();
        this.phoneNumber = form.getPhoneNumber();
        this.email = form.getEmail();
    }

    @Override
    public String toString() {
        return "Client [id=" + id + ", name=" + name + ", surname=" + surname + ", address=" + address
                + ", identityNumber=" + identityNumber + ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
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
