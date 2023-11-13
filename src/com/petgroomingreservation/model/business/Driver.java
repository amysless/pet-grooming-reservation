package com.petgroomingreservation.model.business;

import com.petgroomingreservation.model.domain.Address;
import com.petgroomingreservation.model.services.addressservice.AddressServiceImpl;
import com.petgroomingreservation.model.services.addressservice.IAddressService;
import com.petgroomingreservation.model.services.exception.InputDataException;
import com.petgroomingreservation.model.services.factory.ServiceFactory;


public class Driver {
    public static void main(String[] args) throws InputDataException {

        ServiceFactory factory = new ServiceFactory();
        IAddressService addressService = factory.getAddressService();

        Address newAddress = new Address(
                12345,
                "901 S 2nd Street",
                "Minneapolis",
                "MN",
                "55415");

        Address testCreateAddress = addressService.createAddress(newAddress);
        System.out.println(testCreateAddress + " testCreate");

        Address testGetAddress = addressService.getAddressById(12345);
        System.out.println(testGetAddress + " testGet");



        Address updateAddress = new Address(
                12345,
                "4 Linden St",
                "Boston",
                "MA",
                "02127");

        Address updatedToAddresss = addressService.updateAddress(updateAddress);
        System.out.println(updatedToAddresss + " updated Address");

        boolean result = addressService.deleteAddress(12345);
        System.out.println(result + " testDelete");
    }
}