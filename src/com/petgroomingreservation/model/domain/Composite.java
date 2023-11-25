package com.petgroomingreservation.model.domain;

import java.io.Serializable;

/**
 * Composite object that holds customer's information, associated pets,
 * personal information and list of reservations.
 * <p>
 * This class also behaves as a reservation cart holding above information.
 */
public class Composite implements Serializable {

    /**
     *
     */
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
     * Pet info
     */
    private Pet pet;

    /**
     * Breed of Pet and available services
     */
    private Breed breed;


    /**
     * @param
     */
    public Composite() {
    }


    /**
     * @return Returns the reservations.
     */
    public Reservation getReservations() {
        return reservation;
    }

    /**
     * @param reservation The itinerary to set.
     */
    public void setReservations(Reservation reservation) {
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


    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\nCustomer Info :\n");
        stringBuffer.append(customer);
        stringBuffer.append("\nReservations :\n");
        stringBuffer.append(reservation);
        stringBuffer.append("\n Pet :\n");
        stringBuffer.append(pet);
        stringBuffer.append("\nBreed :\n");
        stringBuffer.append(breed);

        return stringBuffer.toString();
    }


} //end class Composite