package com.petgroomingreservation.model.services.reservationservice;

import com.petgroomingreservation.model.domain.Composite;
import com.petgroomingreservation.model.domain.Reservation;
import com.petgroomingreservation.model.services.IService;
import com.petgroomingreservation.model.services.exception.InputDataException;
import com.petgroomingreservation.model.services.exception.ReservationException;

public interface IReservationService extends IService {

    public final String NAME = "IReservationService";

    boolean createReservation(Composite composite) throws ReservationException;

    Reservation getReservationById(long reservationId) throws InputDataException, ReservationException;

    Reservation updateReservation(Reservation reservation) throws InputDataException;

    boolean deleteReservation(Composite composite) throws ReservationException;

}
