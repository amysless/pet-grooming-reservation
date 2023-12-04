package com.petgroomingreservation.model.services.customerservice;

import com.petgroomingreservation.model.business.exception.ServiceLoadException;
import com.petgroomingreservation.model.domain.*;
import com.petgroomingreservation.model.services.addressservice.IAddressService;
import com.petgroomingreservation.model.services.exception.CustomerException;
import com.petgroomingreservation.model.services.exception.InputDataException;
import com.petgroomingreservation.model.services.factory.ServiceFactory;
import com.petgroomingreservation.model.services.reservationservice.IReservationService;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class CustomerServiceImplTest {

    ICustomerService customerService;

    @Before
    public void setUp() throws InputDataException, ServiceLoadException {
//        ServiceFactory serviceFactory = new ServiceFactory();
//        customerService = serviceFactory.getService(ICustomerService.NAME);
    }
//todo fix
//    @Test
//    public final void testCreateValid() throws InputDataException {
//        System.out.println("starting testCreate()");
//        List<Pet> petList = new ArrayList<>();
//        Pet pet = new Pet("Poppy",50.5, LocalDate.of(2021, 4,1), new Breed("Dalmatian"));
//        petList.add(pet);
//
//        Customer customer = new Customer(12455L,"sdkjfkgj","fdjfkg","akldjklfj@slkfj.com","FJFKGG","1231231234","1234123123",new Address(1,"12355","1kjfkg","dkjk","029394"),true,petList);
//
//        Customer newCustomer = customerService.createCustomer(customer);
//        assertNotNull(newCustomer);
//        assertEquals(customer, newCustomer);
//    }

    //todo fix
//    @Test
//    public final void testGetCustomerById() throws InputDataException {
//        System.out.println("starting testGetCustomerById()");
//        List<Pet> petList = new ArrayList<>();
//        Pet pet = new Pet("Poppy",50.5, LocalDate.of(2021, 4,1), new Breed("Dalmatian"));
//        petList.add(pet);
//
//        Customer customer = new Customer(12455L,"sdkjfkgj","fdjfkg","akldjklfj@slkfj.com","FJFKGG","1231231234","1234123123",new Address(1,"12355","1kjfkg","dkjk","029394"),true,petList);
//        customer = customerService.createCustomer(customer);
//
//        Customer newCustomer = customerService.getCustomerById(12455L);
//        assertNotNull(newCustomer);
//        assertEquals(customer, newCustomer);    }

    //todo fix
//    @Test
//    public final void testDeleteCustomer() throws InputDataException, CustomerException {
//        System.out.println("starting testDeleteCustomer()");
//        List<Pet> petList = new ArrayList<>();
//        Pet pet = new Pet("Poppy",50.5, LocalDate.of(2021, 4,1), new Breed("Dalmatian"));
//        petList.add(pet);
//
//        Customer customer = new Customer(12455L,"sdkjfkgj","fdjfkg","akldjklfj@slkfj.com","FJFKGG","1231231234","1234123123",new Address(1,"12355","1kjfkg","dkjk","029394"),true,petList);
//
//        customer = customerService.createCustomer(customer);
//
//        boolean state = customerService.deleteCustomer(12455L);
//        assertEquals(true, state);
//    }

    //todo fix
//    @Test
//    public final void testUpdateCustomer() throws InputDataException,CustomerException {
//        System.out.println("starting testUpdateCustomer()");
//        List<Pet> petList = new ArrayList<>();
//        Pet pet = new Pet("Poppy",50.5, LocalDate.of(2021, 4,1), new Breed("Dalmatian"));
//        petList.add(pet);
//
//        Customer customer = new Customer(12455L,"sdkjfkgj","fdjfkg","akldjklfj@slkfj.com","FJFKGG","1231231234","1234123123",new Address(1,"12355","1kjfkg","dkjk","029394"),true,petList);
//        customer = customerService.createCustomer(customer);
//
//        Customer customerNew =  new Customer(12455L,"AAAAAAAA","fdjfkg","akldjklfj@slkfj.com","FJFKGG","1231231234","1234123123",new Address(1,"12355","1kjfkg","dkjk","029394"),true,petList);
//        Customer expectedResult = customerService.updateCustomer(customerNew);
//        assertEquals(expectedResult, customerNew);
//    }

    //todo fix
//    @Test
//    public void testCreateCustomerExceptionThrown() {
//        InputDataException exception = assertThrows(InputDataException.class, () -> {
//            Customer createCustomer = customerService.createCustomer(null);
//        });
//    }

    @Test
    public void testUpdateCustomerExceptionThrown() {
        CustomerException exception = assertThrows(CustomerException.class, () -> {
            List<Pet> petList = new ArrayList<>();
            Pet pet = new Pet("Poppy",50.5, LocalDate.of(2021, 4,1), new Breed("Dalmatian"));
            petList.add(pet);

            Customer customer = new Customer(12455L,"sdkjfkgj","fdjfkg","akldjklfj@slkfj.com","FJFKGG","1231231234","1234123123",new Address(1,"12355","1kjfkg","dkjk","029394"),true,petList);
            Customer expectedResult = customerService.updateCustomer(customer);
        });
    }

    //todo fix
//    @Test
//    public void testDeleteCustomerExceptionThrown() {
//        Exception exception = assertThrows(Exception.class, () -> {
//            List<Pet> petList = new ArrayList<>();
//            Pet pet = new Pet("Poppy",50.5, LocalDate.of(2021, 4,1), new Breed("Dalmatian"));
//            petList.add(pet);
//
//            Customer customer = new Customer(12455L,"sdkjfkgj","fdjfkg","akldjklfj@slkfj.com","FJFKGG","1231231234","1234123123",new Address(1,"12355","1kjfkg","dkjk","029394"),true,petList);
//            boolean state = customerService.deleteCustomer(customer.getCustomerId());
//        });
//    }
}
