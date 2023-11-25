package com.petgroomingreservation.model.business;

import com.petgroomingreservation.model.business.exception.ServiceLoadException;

import com.petgroomingreservation.model.services.addressservice.IAddressService;
import com.petgroomingreservation.model.services.customerservice.ICustomerService;
import com.petgroomingreservation.model.services.exception.AddressException;
import com.petgroomingreservation.model.services.exception.CustomerException;
import com.petgroomingreservation.model.services.exception.InputDataException;
import com.petgroomingreservation.model.services.exception.ReservationException;
import com.petgroomingreservation.model.services.factory.ServiceFactory;
import com.petgroomingreservation.model.services.reservationservice.IReservationService;
import com.petgroomingreservation.model.services.loginservice.ILoginService;


public class Driver {
    public static void main(String[] args) throws InputDataException, AddressException, ServiceLoadException, ReservationException {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ILoginService loginService;
        System.out.println("Testing ServiceLoadException...");

        try {
            loginService = (ILoginService) serviceFactory.getService("test");
            System.out.println("testGetLoginService PASSED");
        } catch (ServiceLoadException e) {
            System.out.println("ServiceLoadException Caught");
        }

        System.out.println("Testing AddressException...");
        IAddressService addressService;
        try {
            addressService = (IAddressService) serviceFactory.getService(IAddressService.NAME);
            try {
                addressService.createAddress(null);
            } catch (AddressException e) {
                System.out.println("AddressException Caught");
            }
        } catch (ServiceLoadException e) {
            e.printStackTrace();
        }


        System.out.println("Testing ReservationException...");
        IReservationService reservationService;
        try {
            reservationService = (IReservationService) serviceFactory.getService(IReservationService.NAME);
            try {
                reservationService.createReservation(null);
            } catch (InputDataException e) {
                System.out.println("InputDataException Caught");
            }
        } catch (ServiceLoadException e) {
            e.printStackTrace();
        }


    System.out.println("Testing InputDataException...");
    ICustomerService customerService;
        try {
        customerService = (ICustomerService) serviceFactory.getService(ICustomerService.NAME);
        try {
            customerService.createCustomer(null);
        } catch (InputDataException e) {
            System.out.println("CustomerException Caught");
        }
    } catch (ServiceLoadException e) {
        e.printStackTrace();
    }
}}
