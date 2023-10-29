package com.petgroomingreservation.model.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Reservations {
    private long reservationId;

    private LocalDateTime appointment;

    private Pet pet;

    private Customer customer;

    private List<GroomingServices> groomingServices;

    //no args constructor
    public Reservations(){
    }

    //all args constructor
    public Reservations(long reservationId, LocalDateTime appointment, Pet pet, Customer customer, List<GroomingServices> groomingServices) {
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

    public List<GroomingServices> getGroomingServices() {
        return groomingServices;
    }

    public void setGroomingServices(List<GroomingServices> groomingServices) {
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
        if (!(o instanceof Reservations that)) return false;
        return reservationId == that.reservationId && Objects.equals(appointment, that.appointment) && Objects.equals(pet, that.pet) && Objects.equals(customer, that.customer) && Objects.equals(groomingServices, that.groomingServices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationId, appointment, pet, customer, groomingServices);
    }
}
