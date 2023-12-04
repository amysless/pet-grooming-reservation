package com.petgroomingreservation.model.domain;

import com.petgroomingreservation.model.services.exception.InputDataException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
  Customer domain to contain relevant information about a customer
 */

public class Customer implements Serializable {

    private long customerId;

    private String lastName;

    private String firstName;

    private String emailAddress;

    private String password;

    private String homePhone;

    private String mobilePhone;

    private Address address;

    private Boolean optInNotifications;

    private List<Pet> pets;

    //no args constructor
    public Customer() {
    }

    public Customer(Composite composite){
        customerId = composite.getCustomer().getCustomerId();
        lastName = composite.getCustomer().getLastName();
        firstName = composite.getCustomer().getFirstName();
        emailAddress = composite.getCustomer().getEmailAddress();
        password = composite.getCustomer().getPassword();
        homePhone = composite.getCustomer().getHomePhone();
        mobilePhone = composite.getCustomer().getMobilePhone();
        address = composite.getCustomer().getAddress();
        optInNotifications = composite.getCustomer().getOptInNotifications();
        pets = composite.getCustomer().getPets();
    }
    //all parameters constuctor
    public Customer(Long customerId, String lastName, String firstName, String emailAddress, String password, String homePhone, String mobilePhone, Address address, Boolean optInNotifications, List<Pet> pets) {
        this.customerId = customerId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.address = address;
        this.optInNotifications = optInNotifications;
        this.pets = pets;
    }

    public Customer(long customerid, String lastname, String firstname, String emailaddress, String password, String homephone, String mobilephone, String address, String optinnotifications, String pets) {
        this.customerId = customerid;
        this.lastName = lastname;
        this.firstName = firstname;
        this.emailAddress = emailaddress;
        this.password = password;
        this.homePhone = homephone;
        this.mobilePhone = mobilephone;
        this.address = new Address();
        this.optInNotifications = true;
        this.pets = new ArrayList<>();
    }

//    public Customer(long customerid, String lastname, String firstname, String emailaddress, String password, String homephone, String mobilephone, String address, String optinnotification, String pets) {
//        this.customerId = customerId;
//        this.lastName = lastName;
//        this.firstName = firstName;
//        this.emailAddress = emailAddress;
//        this.password = password;
//        this.homePhone = homePhone;
//        this.mobilePhone = mobilePhone;
//        this.optInNotifications = optInNotifications;
//    }

    //getters and setters

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Boolean getOptInNotifications() {
        return optInNotifications;
    }

    public void setOptInNotifications(Boolean optInNotifications) {
        this.optInNotifications = optInNotifications;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }


    //toString method, can be used for logging
    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", address=" + address +
                ", optInNotifications=" + optInNotifications +
                ", pets=" + pets +
                '}';
    }

    //equals method to validate objects

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return Objects.equals(customerId, customer.customerId) && Objects.equals(lastName, customer.lastName) && Objects.equals(firstName, customer.firstName) && Objects.equals(emailAddress, customer.emailAddress) && Objects.equals(password, customer.password) && Objects.equals(homePhone, customer.homePhone) && Objects.equals(mobilePhone, customer.mobilePhone) && Objects.equals(address, customer.address) && Objects.equals(optInNotifications, customer.optInNotifications) && Objects.equals(pets, customer.pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, lastName, firstName, emailAddress, password, homePhone, mobilePhone, address, optInNotifications, pets);
    }

    public void validate() throws InputDataException {
        if (customerId == 0) {
            throw new InputDataException("customerId cannot be null or empty");
        }
        if (lastName == null || lastName.isEmpty()) {
            throw new InputDataException("lastName cannot be null or empty");
        }
        if (firstName == null || firstName.isEmpty()) {
            throw new InputDataException("firstName cannot be null or empty");
        }
        if (emailAddress == null || emailAddress.isEmpty()) {
            throw new InputDataException("emailAddress cannot be null or empty");
        }
        if (password == null || password.isEmpty()) {
            throw new InputDataException("password cannot be null or empty");
        }
        if (homePhone == null || homePhone.isEmpty()) {
            throw new InputDataException("homePhone cannot be null or empty");
        }
        if (mobilePhone == null || mobilePhone.isEmpty()) {
            throw new InputDataException("mobilePhone cannot be null or empty");
        }
        if (address == null) {
            throw new InputDataException("address cannot be null");
        }
        if (pets == null || pets.isEmpty()) {
            throw new InputDataException("pets cannot be null or empty");
        }
    }
}
