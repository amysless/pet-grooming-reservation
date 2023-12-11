package com.petgroomingreservation.model.presentation;

import com.petgroomingreservation.model.business.manager.ReservationManager;
import com.petgroomingreservation.model.domain.Address;
import com.petgroomingreservation.model.domain.Breed;
import com.petgroomingreservation.model.domain.Composite;
import com.petgroomingreservation.model.domain.Customer;
import com.petgroomingreservation.model.domain.GroomingService;
import com.petgroomingreservation.model.domain.Pet;
import com.petgroomingreservation.model.domain.Reservation;
import com.petgroomingreservation.model.persistence.BreedDao;
import com.petgroomingreservation.model.persistence.GroomingServicesDao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Driver {
    private static BreedDao breedDao;
    private static GroomingServicesDao groomingServicesDao;

    public static void main(String[] args) {
        boolean success;
        Address address;
        Breed breed;
        Composite composite = null;
        Customer customer;
        GroomingService groomingService;
        Pet pet;
        Reservation reservation = null;
        List<Customer> customerList = new ArrayList<>();
        List<Reservation> reservationList = new ArrayList<>();
        ReservationManager reservationManager;

        Scanner input = new Scanner(System.in);
        int choice = -1;
        while (choice != 4) {
            System.out.println("-----Pet Grooming Reservation System-----");
            System.out.println("1. List Breeds");
            System.out.println("2. List Services");
            System.out.println("3. Add Services");

            System.out.println("4. Exit");
            try {
                System.out.print("Please make a choice: ");
                choice = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please make a valid choice.");
                input.next();
            }

            if (choice == 1) {
                List<Breed> breedArrayList = listBreeds();

                for (int i = 0; i < breedArrayList.size(); i++) {
                    breed = breedArrayList.get(i);
                    System.out.println("Breed: " + breed.getBreed());
                }
            } else if (choice == 2) {
                List<GroomingService> groomingServiceList = listServices();
                for (int i = 0; i < groomingServiceList.size(); i++) {
                    groomingService = groomingServiceList.get(i);
                    System.out.println("Service: " + groomingService.getServiceName() + " Time: " + groomingService.getMinutes() + " minutes");
                }
            } else if (choice == 3) {
                groomingService  = new GroomingService();
                System.out.print("Please input name of service: ");
                groomingService.setServiceName(input.next());

                System.out.print("Please input duration in minutes: ");
                groomingService.setMinutes(input.nextInt());

                addServices(groomingService);

            }
        }
    }

    protected static List<Breed> listBreeds() {
        List<Breed> breeds = new ArrayList<>();
        breedDao = new BreedDao();
        breeds = breedDao.getAllBreeds();
        return breeds;
    }

    private static List<GroomingService> listServices() {
        List<GroomingService> groomingServiceList = new ArrayList<>();
        groomingServicesDao = new GroomingServicesDao();
        groomingServiceList = groomingServicesDao.getAllGroomingServices();
        return groomingServiceList;
    }

    private static boolean addServices(GroomingService groomingService) {
        boolean success;
        List<GroomingService> groomingServiceList = new ArrayList<>();
        groomingServicesDao = new GroomingServicesDao();
        groomingServiceList = groomingServicesDao.getAllGroomingServices();
        int listSize = groomingServiceList.size();
        groomingService.setServiceId(listSize +1);
        success = groomingServicesDao.add(groomingService);
        return success;

    }
}
