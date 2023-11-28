package com.petgroomingreservation.model.services.addressservice;

import com.petgroomingreservation.model.domain.Address;
import com.petgroomingreservation.model.domain.Composite;
import com.petgroomingreservation.model.services.IService;
import com.petgroomingreservation.model.services.exception.AddressException;
import com.petgroomingreservation.model.services.exception.InputDataException;

public interface IAddressService extends IService {
    public final String NAME = "IAddressService";

    boolean createAddress(Composite composite) throws AddressException;

    Address getAddressById(long addressId) throws InputDataException, AddressException;

    Address updateAddress(Address address) throws InputDataException, AddressException;

    boolean deleteAddress(long addressId) throws InputDataException, AddressException;

}
