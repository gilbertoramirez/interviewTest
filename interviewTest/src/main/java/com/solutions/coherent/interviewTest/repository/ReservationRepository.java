package com.solutions.coherent.interviewTest.repository;

import com.solutions.coherent.interviewTest.configuration.DBMemory;
import com.solutions.coherent.interviewTest.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ReservationRepository {
    private static final String DATA_BASE_FILE = "database.dat";

    @Autowired
    private DBMemory dbMemory;

    public void saveReservation(Reservation reservation){
        dbMemory.addItem(reservation);
    }
    public Set<Reservation> getReservation(){
        return dbMemory.getList();
    }
    public void updateReservation(int id, Reservation reservation){
        dbMemory.updateReservation(id, reservation);
    }
}
