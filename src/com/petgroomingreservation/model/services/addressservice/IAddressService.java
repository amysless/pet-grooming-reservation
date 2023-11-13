package com.petgroomingreservation.model.services.addressservice;

import com.petgroomingreservation.model.domain.Address;
import com.petgroomingreservation.model.services.exception.InputDataException;

public interface IAddressService {
    Address createAddress(Address address) throws InputDataException;

    Address getAddressById(long addressId) throws InputDataException;

    Address updateAddress(Address address) throws InputDataException;

    boolean deleteAddress(long addressId) throws InputDataException;

}
