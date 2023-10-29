package com.petgroomingreservation.model.domain;

import java.util.Objects;

/*
  Address domain to contain relevant address information of a customer
 */
public class Address {

    private String address;

    private String city;

    private String state;

    private String zipCode;

    //default/no args constructor
   public Address(){
   }

   //parameterized constuctor
    public Address(String address, String city, String state, String zipCode) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }


    //getters and setters for all parameters
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    //toString method, can be used for logging
    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    //equals method to validate objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address address1)) return false;
        return Objects.equals(address, address1.address) && Objects.equals(city, address1.city) && Objects.equals(state, address1.state) && Objects.equals(zipCode, address1.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, city, state, zipCode);
    }
}
