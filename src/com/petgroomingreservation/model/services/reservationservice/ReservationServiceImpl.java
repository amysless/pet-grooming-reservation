package com.petgroomingreservation.model.services.reservationservice;

import com.petgroomingreservation.model.domain.Reservation;
import com.petgroomingreservation.model.services.exception.InputDataException;
import com.petgroomingreservation.model.services.exception.ReservationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ReservationServiceImpl implements IReservationService {

    private final List<Reservation> reservationList = new ArrayList<>();

    public Reservation createReservation(Reservation reservation) throws InputDataException {
        System.out.println("Entering method ReservationsServiceImpl::createReservations");
        try {
            System.out.println("Entering method ReservationsServiceImpl::createReservations");
            reservation.validate();
            reservationList.add(reservation);
            return reservation;
        } catch (Exception e) {
            System.out.println("Failed to create customer: " + e.getMessage());
            throw new InputDataException("Failed to create customer: " + e.getMessage());
        }
    }

    public Reservation getReservationById(long reservationId) throws InputDataException {

        try {
            System.out.println("Entering method ReservationsServiceImpl::getReservationsById");

            return reservationList.stream()
                    .filter(p -> Objects.equals(reservationId, p.getReservationId()))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            throw new InputDataException("Failed to retrieve reservations: " + e.getMessage());
        }
    }

    public Reservation updateReservation(Reservation reservation) throws InputDataException {
        System.out.println("Entering method ReservationsServiceImpl::updateReservations");
        reservation.validate();

        Optional<Reservation> existingReservations = reservationList.stream()
                .filter(a -> Objects.equals(a.getReservationId(), reservation.getReservationId()))
                .findFirst();

        if (existingReservations.isPresent()) {
            Reservation toUpdate = existingReservations.get();

            toUpdate.setAppointment(reservation.getAppointment());
            toUpdate.setPet(reservation.getPet());
            toUpdate.setCustomer(reservation.getCustomer());
            toUpdate.setGroomingServices(reservation.getGroomingServices());
            System.out.println("Reservation updated for id: " + toUpdate.getReservationId());
            return toUpdate;
        } else {
            throw new InputDataException("No Reservation found for id " + reservation.getReservationId());
        }
    }

    public boolean deleteReservation(long reservationId) throws ReservationException, InputDataException {
        System.out.println("Entering method CustomerServiceImpl::deleteCustomer");

        Reservation id = this.getReservationById(reservationId);
        if (id == null) {
            throw new ReservationException();
        } else {
            return true;
        }
    }
}

