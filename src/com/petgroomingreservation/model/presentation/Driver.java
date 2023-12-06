package com.petgroomingreservation.model.presentation;

import com.petgroomingreservation.model.business.manager.ReservationManager;
import com.petgroomingreservation.model.domain.Address;
import com.petgroomingreservation.model.domain.Breed;
import com.petgroomingreservation.model.domain.Composite;
import com.petgroomingreservation.model.domain.Customer;
import com.petgroomingreservation.model.domain.GroomingService;
import com.petgroomingreservation.model.domain.Pet;
import com.petgroomingreservation.model.domain.Reservation;
import com.petgroomingreservation.model.persistence.CustomerDao;
import com.petgroomingreservation.model.persistence.GroomingServicesDao;


import java.time.LocalDate;
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
        List<Customer> customerList = new ArrayList<>();
        List<Reservation> reservationList = new ArrayList<>();
        ReservationManager reservationManager;
        CustomerDao customerDao;
        GroomingServicesDao groomingServicesDao;


        //wk5 instantiate & configure Composite obj, pass it to services, print returned output from methods
        List<GroomingService> groomingServiceList = new ArrayList<>();
        groomingService = new GroomingService(1, "Bath", 30);
//        groomingServiceList.add(groomingService);
//        groomingService = new GroomingService(2, "Nails", 10);
//        groomingServiceList.add(groomingService);
        breed = new Breed("Dalmatian", groomingServiceList);
        List<Pet> petList = new ArrayList<>();
        pet = new Pet("Poppy", 54.5, LocalDate.of(2021, 4, 1), breed);
        petList.add(pet);

        // create an address and a customer
        address = new Address(123, "4 Linden Street", "Boston", "MA", "01234");
        customer = new Customer(111L, "Sless", "Amy", "asless@regis.edu", "dkjfglg", "7819855231", "7819855231", address, true, petList);

        //week 7 database
        try {
            groomingServicesDao = new GroomingServicesDao();
            success = groomingServicesDao.add(groomingService);
            groomingService = new GroomingService(2, "Nails", 10);
            success = groomingServicesDao.add(groomingService);
            groomingServiceList = groomingServicesDao.getAllGroomingServices();
            System.out.println(groomingServiceList);
            System.out.println("READ database success: " + success + "\n Grooming Services from DB:");
            for (GroomingService g : groomingServiceList) {
                System.out.println(" " + g);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
