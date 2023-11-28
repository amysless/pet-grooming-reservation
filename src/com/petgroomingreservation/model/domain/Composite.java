package com.petgroomingreservation.model.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * Composite object that holds customer's information, associated pets,
 * personal information and list of reservations.
 * <p>
 * This class also behaves as a reservation cart holding above information.
 */
public class Composite implements Serializable {

    private static final long serialVersionUID = -334371602256955290L;

    /**
     * Holds information of the customer
     */
    private Customer customer;

    /**
     * Holds the list of existing reservations
     */
    private Reservation reservation;

    /**
     * Holds Address infro
     */
    private Address address;
    /**
     * Pet info
     */
    private Pet pet;

    /**
     * Breed of Pet and available services
     */
    private Breed breed;


    private HashMap<LocalDateTime, String> updates;

    /**
     * @param
     */
    public Composite() {
        address = new Address();
        customer = new Customer();
        reservation = new Reservation();
        updates = new HashMap<>();
    }

    public Composite(Address address, Customer customer, Reservation reservation){
        this.address = address;
        this.customer = customer;
        this.reservation = reservation;
        updates = new HashMap<>();
    }
    /**
     * @return Returns the reservations.
     */
    public Reservation getReservation() {
        return reservation;
    }

    /**
     * @param reservation The itinerary to set.
     */
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    /**
     * @return Returns the customer.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer The customer to set.
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * @return Returns the pet.
     */
    public Pet getPet() {
        return pet;
    }

    /**
     * @param breed The breed to set.
     */
    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public void addUpdate(LocalDateTime dt, String comment) {
        updates.put(dt, comment);
    }


    @Override
    public String toString() {
        return "\nComposite Info: " +
                "\n" + address +
                "\n" + customer +
                "\n" + reservation +
                "\nupdates: " + updates;
    }

} //end class Composite