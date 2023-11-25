package com.petgroomingreservation.model.domain;

import com.petgroomingreservation.model.services.exception.InputDataException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Reservation {
    private long reservationId;

    private LocalDateTime appointment;

    private Pet pet;

    private Customer customer;

    private List<GroomingService> groomingServices;

    //no args constructor
    public Reservation() {
    }

    //all args constructor
    public Reservation(long reservationId, LocalDateTime appointment, Pet pet, Customer customer, List<GroomingService> groomingServices) {
        this.reservationId = reservationId;
        this.appointment = appointment;
        this.pet = pet;
        this.customer = customer;
        this.groomingServices = groomingServices;
    }

    //getters and setters
    public long getReservationId() {
        return reservationId;
    }

    public void setReservationId(long reservationId) {
        this.reservationId = reservationId;
    }

    public LocalDateTime getAppointment() {
        return appointment;
    }

    public void setAppointment(LocalDateTime appointment) {
        this.appointment = appointment;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<GroomingService> getGroomingServices() {
        return groomingServices;
    }

    public void setGroomingServices(List<GroomingService> groomingServices) {
        this.groomingServices = groomingServices;
    }

    //toString method
    @Override
    public String toString() {
        return "Reservations{" +
                "reservationId=" + reservationId +
                ", appointment=" + appointment +
                ", pet=" + pet +
                ", customer=" + customer +
                ", groomingServices=" + groomingServices +
                '}';
    }

    //equals method to validate objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation that)) return false;
        return reservationId == that.reservationId && Objects.equals(appointment, that.appointment) && Objects.equals(pet, that.pet) && Objects.equals(customer, that.customer) && Objects.equals(groomingServices, that.groomingServices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationId, appointment, pet, customer, groomingServices);
    }

    public void validate() throws InputDataException {
        if (reservationId == 0) {
            throw new InputDataException("reservationId cannot be null or empty");
        }
        if (appointment == null) {
            throw new InputDataException("appointment cannot be null or empty");
        }
        if (pet == null) {
            throw new InputDataException("pet cannot be null");
        }
        if (customer == null) {
            throw new InputDataException("customer cannot be null");
        }
        if (groomingServices == null) {
            throw new InputDataException("groomingServices cannot be null or empty");
        }
    }
}
