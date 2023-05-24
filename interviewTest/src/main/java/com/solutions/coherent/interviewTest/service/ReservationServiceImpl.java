package com.solutions.coherent.interviewTest.service;

import com.solutions.coherent.interviewTest.model.Reservation;
import com.solutions.coherent.interviewTest.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class ReservationServiceImpl implements ReservationService{

    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void createReservation(Reservation reservation) {
        reservationRepository.saveReservation(reservation);
    }

    @Override
    public Set<Reservation> getReservation() {
        return reservationRepository.getReservation();
    }

    @Override
    public void updateReservationById(int id, Reservation reservation) {
        reservationRepository.updateReservation(id, reservation);
    }
}
