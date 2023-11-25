package com.petgroomingreservation.model.services.reservationservice;

import com.petgroomingreservation.model.domain.Reservation;
import com.petgroomingreservation.model.services.IService;
import com.petgroomingreservation.model.services.exception.InputDataException;
import com.petgroomingreservation.model.services.exception.ReservationException;

public interface IReservationService extends IService {

    public final String NAME = "IReservationService";

    Reservation createReservation(Reservation reservation) throws InputDataException;

    Reservation getReservationById(long reservationId) throws InputDataException;

    Reservation updateReservation(Reservation reservation) throws InputDataException;

    boolean deleteReservation(long reservationId) throws InputDataException, ReservationException;

}
