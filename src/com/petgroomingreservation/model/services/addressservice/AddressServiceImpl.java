package com.petgroomingreservation.model.services.addressservice;

import com.petgroomingreservation.model.domain.Address;
import com.petgroomingreservation.model.services.exception.InputDataException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class AddressServiceImpl implements IAddressService {

    private final List<Address> addresses = new ArrayList<>();

    public Address createAddress(Address address) throws InputDataException {
        System.out.println("Entering method AddressServiceImpl::createAddress");
        try {
            System.out.println("Entering method AddressServiceImpl::createAddress");
            address.validate();
            addresses.add(address);
            return address;
        } catch (Exception | InputDataException e) {
            System.out.println("Failed to create address: " + e.getMessage());
            throw new InputDataException("Failed to create address: " + e.getMessage());
        }
    }

    public Address getAddressById(long addressId) throws InputDataException {

        try {
            System.out.println("Entering method getAddressbyId::getAddress");

            return addresses.stream()
                    .filter(p -> Objects.equals(addressId, p.getAddressId()))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            throw new InputDataException("Failed to retrieve address: " + e.getMessage());
        }
    }

    public Address updateAddress(Address address) throws InputDataException {
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
            throw new InputDataException("No address found for id " + address.getAddressId());
        }
    }

    public boolean deleteAddress(long addressId) throws InputDataException {
        try {
            System.out.println("Entering method AddressServiceImpl::deleteAddress");

            return addresses.removeIf(p -> Objects.equals(addressId, p.getAddressId()));
        } catch (Exception e) {
            System.out.println("Failed to delete address: " + e.getMessage());
            throw new InputDataException("No address found for id " + addressId);
        }
    }
}

