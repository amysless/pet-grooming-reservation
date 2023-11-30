package com.petgroomingreservation.model.presentation;

import com.petgroomingreservation.model.business.manager.ReservationManager;
import com.petgroomingreservation.model.domain.Address;
import com.petgroomingreservation.model.domain.Breed;
import com.petgroomingreservation.model.domain.Composite;
import com.petgroomingreservation.model.domain.Customer;
import com.petgroomingreservation.model.domain.GroomingService;
import com.petgroomingreservation.model.domain.Pet;
import com.petgroomingreservation.model.domain.Reservation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        boolean success;
        Address address;
        Breed breed;
        Composite composite;
        Customer customer;
        GroomingService groomingService;
        Pet pet;
        Reservation reservation = null;
        ReservationManager reservationManager;

        //wk5 instantiate & configure Composite obj, pass it to services, print returned output from methods
        List<GroomingService> groomingServiceList = new ArrayList<>();
        groomingService = new GroomingService("Bath", 30);
        groomingServiceList.add(groomingService);
        groomingService = new GroomingService("Nails", 10);
        groomingServiceList.add(groomingService);
        breed = new Breed("Dalmatian", groomingServiceList);
        List<Pet> petList = new ArrayList<>();
        pet = new Pet("Poppy", 54.5, LocalDate.of(2021, 4, 1), breed);
        petList.add(pet);

        // create an address and a customer
        address = new Address(123, "4 Linden Street", "Boston", "MA", "01234");
        customer = new Customer(111L, "Sless", "Amy", "asless@regis.edu", "dkjfglg", "7819855231", "7819855231", address, true, petList);

        // create composite
        composite = new Composite(address,customer,reservation);
        composite.addUpdate(LocalDateTime.now(), "composite created");

        try {
            reservationManager = ReservationManager.getInstance();

            System.out.println("attempting CREATE_ADDRESS");
            success = reservationManager.performAction("CREATE_ADDRESS", composite);
            System.out.println("CREATE_ADDRESS success from perform action: " + success);

            System.out.println("attempting CREATE_RESERVATION");

            success = reservationManager.performAction("CREATE_RESERVATION", composite);
            System.out.println("CREATE_RESERVATION success from perform action: " + success);


//            System.out.println("address before creating customer: " + composite.getAddress());
//            success = reservationManager.performAction("CREATE_CUSTOMER", composite);
//            System.out.println("Create Customer success: " + success +
//                    "\ncustomer after update: " + composite.getCustomer());
//
//            success = reservationManager.performAction("CHECK_CUSTOMER", composite);
//            System.out.println(success + " status of CHECK_CUSTOMER ");
//            System.out.println("Check Customer success: " + success +
//                    "\ncustomer after update: " + composite.getCustomer());
//            success = manager.performAction("CANCEL_RESERVATION", composite);
//            System.out.println("CANCEL RESERVATION success: " + success);
//


        } catch (Exception e) {
            System.err.println("Exception from main: " + e.getMessage());
        }

    }
}