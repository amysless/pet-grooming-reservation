package com.petgroomingreservation.model.services.addressservice;

import com.petgroomingreservation.model.domain.Address;
import com.petgroomingreservation.model.domain.Composite;
import com.petgroomingreservation.model.services.exception.AddressException;
import com.petgroomingreservation.model.services.exception.InputDataException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class AddressServiceImpl implements IAddressService {

    private final List<Address> addresses = new ArrayList<>();

    public boolean createAddress(Composite composite) throws AddressException {
        System.out.println("Entering method AddressServiceImpl::createAddress");
        Address address = composite.getAddress();
        try {
            System.out.println("Entering method AddressServiceImpl::createAddress");
            address.validate();
            addresses.add(address);
            return true;
        } catch (Exception  e) {
            System.out.println("Failed to create address: " + e.getMessage());
            throw new AddressException("Failed to create address: " + e.getMessage());
        }
    }

    public Address getAddressById(long addressId) throws AddressException {

        try {
            System.out.println("Entering method getAddressbyId::getAddress");

            return addresses.stream()
                    .filter(p -> Objects.equals(addressId, p.getAddressId()))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            throw new AddressException("Failed to retrieve address: " + e.getMessage());
        }
    }

    public Address updateAddress(Address address) throws AddressException, InputDataException {
        System.out.println("Entering method AddressServiceImpl::updateAddress");
        address.validate();

        Optional<Address> existingAddress = addresses.stream()
                .filter(a -> Objects.equals(a.getAddressId(), address.getAddressId()))
                .findFirst();

        if (existingAddress.isPresent()) {
            Address toUpdate = existingAddress.get();
            toUpdate.setAddress(address.getAddress());
            toUpdate.setCity(address.getCity());
            toUpdate.setState(address.getState());
            toUpdate.setZipCode(address.getZipCode());
            System.out.println("Address updated for id: " + toUpdate.getAddressId());
            return toUpdate;
        } else {
            throw new AddressException("No address found for id " + address.getAddressId());
        }
    }

    public boolean deleteAddress(long addressId) throws AddressException {
        System.out.println("Entering method AddressServiceImpl::deleteAddress");

        Address id = this.getAddressById(addressId);
        if (id == null) {
            throw new AddressException("Unable to delete address  " + addressId + " doesn't exist in the system!");
        } else {
            return true;
        }
    }
}

