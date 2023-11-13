package com.petgroomingreservation.model.domain;

import com.petgroomingreservation.model.services.exception.InputDataException;

import java.util.Objects;

/*
  Address domain to contain relevant address information of a customer
 */
public class Address {

    private long addressId;
    private String address;
    private String city;
    private String state;
    private String zipCode;

    //default/no args constructor
    public Address() {
    }

    //parameterized constuctor
    public Address(long addressId, String address, String city, String state, String zipCode) {
        this.addressId = addressId;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }


    //getters and setters for all parameters
    public long getAddressId() {
        return addressId;
    }

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

    public void setAddressId(long addressId) {
        this.addressId = addressId;
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
                "addressId='" + addressId + '\'' +
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
        return Objects.equals(addressId, address1.addressId) && Objects.equals(address, address1.address) && Objects.equals(city, address1.city) && Objects.equals(state, address1.state) && Objects.equals(zipCode, address1.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId, address, city, state, zipCode);
    }

    public void validate() throws InputDataException {
        if (addressId == 0) {
            throw new InputDataException("AddressID cannot be null or empty");
        }
        if (address == null || address.isEmpty()) {
            throw new InputDataException("Address cannot be null or empty");
        }
        if (city == null || city.isEmpty()) {
            throw new InputDataException("City cannot be null or empty");
        }
        if (state == null || state.isEmpty()) {
            throw new InputDataException("State cannot be null or empty");
        }
        if (zipCode == null || state.isEmpty()) {
            throw new InputDataException("Zip Code cannot be null or empty");
        }
    }
}
