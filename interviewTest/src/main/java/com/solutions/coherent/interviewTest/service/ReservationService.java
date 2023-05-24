package com.solutions.coherent.interviewTest.service;

import com.solutions.coherent.interviewTest.model.Reservation;

import java.util.Set;

public interface ReservationService {

    void createReservation(Reservation reservation);
    Set<Reservation> getReservation();
    void updateReservationById(int id, Reservation reservation);


}
