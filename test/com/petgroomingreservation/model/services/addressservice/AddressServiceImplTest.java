package com.petgroomingreservation.model.services.addressservice;

import com.petgroomingreservation.model.business.exception.ServiceLoadException;
import com.petgroomingreservation.model.domain.Address;
import com.petgroomingreservation.model.services.exception.AddressException;
import com.petgroomingreservation.model.services.exception.InputDataException;
import com.petgroomingreservation.model.services.factory.ServiceFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class AddressServiceImplTest {

    IAddressService addressService;

    @Before
    public void setUp() throws AddressException, ServiceLoadException {
        ServiceFactory factory = new ServiceFactory();
        addressService = factory.getAddressService();
    }

    @Test
    public final void testCreateValid() throws AddressException, InputDataException {
        System.out.println("starting testCreate()");
        Address address = new Address(1, "122345 Missy Blvd", "BOSTON", "MA", "02127");

        Address newAddress = addressService.createAddress(address);
        assertNotNull(newAddress);
        assertEquals(address, newAddress);
    }

    @Test
    public final void testGetAddreressbyId() throws AddressException, InputDataException {
        System.out.println("starting testGetAddreressbyId()");
        Address address = new Address(1, "122345 Missy Blvd", "BOSTON", "MA", "02127");
        address = addressService.createAddress(address);

        Address newAddress = addressService.getAddressById(1);
        assertNotNull(newAddress);
        assertEquals(address, newAddress);
    }

    @Test
    public final void testDeleteAddress() throws AddressException, InputDataException {
        System.out.println("starting testDeleteAddress()");
        Address address = new Address(1, "122345 Missy Blvd", "BOSTON", "MA", "02127");
        address = addressService.createAddress(address);

        boolean state = addressService.deleteAddress(1);
        assertEquals(true, state);
    }

    @Test
    public final void testUpdateAddress() throws AddressException, InputDataException {
        System.out.println("starting testUpdateAddress()");
        Address address = new Address(1, "122345 Missy Blvd", "BOSTON", "MA", "02127");
        address = addressService.createAddress(address);

        Address addressNew = new Address(1, "122345 HOME", "BOSTON", "MA", "02127");
        Address expectedResult = addressService.updateAddress(addressNew);
        assertEquals(expectedResult, addressNew);
    }

    @Test
    public void testCreateAddressExceptionThrown() {
        Exception exception = assertThrows(Exception.class, () -> {
            Address createAddress = addressService.createAddress(null);
        });
    }

    @Test
    public void testUpdateAddressExceptionThrown() {
        Exception exception = assertThrows(Exception.class, () -> {
            Address addressNew = new Address(1, "122345 HOME", "BOSTON", "MA", "02127");
            Address expectedResult = addressService.updateAddress(addressNew);
        });
    }

    @Test
    public void testDeleteAddressExceptionThrown() {
        Exception exception = assertThrows(Exception.class, () -> {
            Address addressNew = new Address(1, "122345 HOME", "BOSTON", "MA", "02127");
            boolean state = addressService.deleteAddress(addressNew.getAddressId());
        });
    }
}
