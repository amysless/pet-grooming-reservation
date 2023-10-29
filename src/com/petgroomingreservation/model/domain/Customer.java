package com.petgroomingreservation.model.domain;

import java.util.List;
import java.util.Objects;

/*
  Customer domain to contain relevant information about a customer
 */

public class Customer {
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

    //all parameters constuctor
    public Customer(String lastName, String firstName, String emailAddress, String password, String homePhone, String mobilePhone, Address address, Boolean optInNotifications, List<Pet> pets) {
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

    //getters and setters
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
        return Objects.equals(lastName, customer.lastName) && Objects.equals(firstName, customer.firstName) && Objects.equals(emailAddress, customer.emailAddress) && Objects.equals(password, customer.password) && Objects.equals(homePhone, customer.homePhone) && Objects.equals(mobilePhone, customer.mobilePhone) && Objects.equals(address, customer.address) && Objects.equals(optInNotifications, customer.optInNotifications) && Objects.equals(pets, customer.pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, emailAddress, password, homePhone, mobilePhone, address, optInNotifications, pets);
    }
}
