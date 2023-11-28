package com.petgroomingreservation.model.services.reservation.service;

import com.petgroomingreservation.model.business.exception.ServiceLoadException;
import com.petgroomingreservation.model.domain.*;
import com.petgroomingreservation.model.services.addressservice.IAddressService;
import com.petgroomingreservation.model.services.customerservice.ICustomerService;
import com.petgroomingreservation.model.services.exception.InputDataException;
import com.petgroomingreservation.model.services.exception.ReservationException;
import com.petgroomingreservation.model.services.factory.ServiceFactory;
import com.petgroomingreservation.model.services.reservationservice.IReservationService;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ReservationServiceImplTest {

    IReservationService reservationService;

    @Before
    public void setUp() throws InputDataException, ServiceLoadException {
        ServiceFactory factory = new ServiceFactory();
        reservationService = factory.getReservationService();
    }
//todo fix
//    @Test
//    public final void testCreateValid() throws InputDataException {
//        System.out.println("starting testCreate()");
//        List<Pet> petList = new ArrayList<>();
//        Pet pet = new Pet("Poppy", 50.5, LocalDate.of(2021, 4, 1), new Breed("Dalmatian"));
//        petList.add(pet);
//        List<GroomingService> groomingServiceList = new ArrayList<>();
//        GroomingService groomingService = new GroomingService("bath", 60);
//        groomingServiceList.add(groomingService);
//        Customer customer = new Customer(12455L, "sdkjfkgj", "fdjfkg", "akldjklfj@slkfj.com", "FJFKGG", "1231231234", "1234123123", new Address(1, "12355", "1kjfkg", "dkjk", "029394"), true, petList);
//
//        Reservation reservation = new Reservation(1244455L, LocalDateTime.of(2023, 12, 12, 9, 15), pet, customer, groomingServiceList);
//        Reservation newReservation = reservationService.createReservation(reservation);
//        assertNotNull(newReservation);
//        assertEquals(reservation, newReservation);
//    }

    //todo fix
//    @Test
//    public final void testGetReservationbyId() throws InputDataException {
//        System.out.println("starting testGetReservationbyId()");
//        List<Pet> petList = new ArrayList<>();
//        Pet pet = new Pet("Poppy", 50.5, LocalDate.of(2021, 4, 1), new Breed("Dalmatian"));
//        petList.add(pet);
//        List<GroomingService> groomingServiceList = new ArrayList<>();
//        GroomingService groomingService = new GroomingService("bath", 60);
//        groomingServiceList.add(groomingService);
//        Customer customer = new Customer(12455L, "sdkjfkgj", "fdjfkg", "akldjklfj@slkfj.com", "FJFKGG", "1231231234", "1234123123", new Address(1, "12355", "1kjfkg", "dkjk", "029394"), true, petList);
//
//        Reservation reservation = new Reservation(1244455L, LocalDateTime.of(2023, 12, 12, 9, 15), pet, customer, groomingServiceList);
//        reservation = reservationService.createReservation(reservation);
//
//        Reservation newReservation = reservationService.getReservationById(1244455L);
//        assertNotNull(newReservation);
//        assertEquals(reservation, newReservation);
//    }

    //todo fix
//    @Test
//    public final void testDeleteReservation() throws InputDataException, ReservationException {
//        System.out.println("starting testDeleteReservation()");
//        List<Pet> petList = new ArrayList<>();
//        Pet pet = new Pet("Poppy", 50.5, LocalDate.of(2021, 4, 1), new Breed("Dalmatian"));
//        petList.add(pet);
//        List<GroomingService> groomingServiceList = new ArrayList<>();
//        GroomingService groomingService = new GroomingService("bath", 60);
//        groomingServiceList.add(groomingService);
//        Customer customer = new Customer(12455L, "sdkjfkgj", "fdjfkg", "akldjklfj@slkfj.com", "FJFKGG", "1231231234", "1234123123", new Address(1, "12355", "1kjfkg", "dkjk", "029394"), true, petList);
//
//        Reservation reservation = new Reservation(1244455L, LocalDateTime.of(2023, 12, 12, 9, 15), pet, customer, groomingServiceList);
//        reservation = reservationService.createReservation(reservation);
//
//        boolean state = reservationService.deleteReservation(1244455L);
//        assertEquals(true, state);
//    }

    //todo fix
//    @Test
//    public final void testUpdateReservation() throws InputDataException {
//        System.out.println("starting testUpdateReservation()");
//        List<Pet> petList = new ArrayList<>();
//        Pet pet = new Pet("Poppy", 50.5, LocalDate.of(2021, 4, 1), new Breed("Dalmatian"));
//        petList.add(pet);
//        List<GroomingService> groomingServiceList = new ArrayList<>();
//        GroomingService groomingService = new GroomingService("bath", 60);
//        groomingServiceList.add(groomingService);
//        Customer customer = new Customer(12455L, "sdkjfkgj", "fdjfkg", "akldjklfj@slkfj.com", "FJFKGG", "1231231234", "1234123123", new Address(1, "12355", "1kjfkg", "dkjk", "029394"), true, petList);
//
//        Reservation reservation = new Reservation(1244455L, LocalDateTime.of(2023, 12, 12, 9, 15), pet, customer, groomingServiceList);
//        reservation = reservationService.createReservation(reservation);
//
//
//        Reservation reservationNew = new Reservation(1244455L, LocalDateTime.of(2023, 12, 22, 9, 15), pet, customer, groomingServiceList);
//        Reservation expectedResult = reservationService.updateReservation(reservationNew);
//        assertEquals(expectedResult, reservation);
//    }

}
