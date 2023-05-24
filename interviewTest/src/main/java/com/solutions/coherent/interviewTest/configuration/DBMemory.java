package com.solutions.coherent.interviewTest.configuration;

import com.solutions.coherent.interviewTest.model.Reservation;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class DBMemory {

    private Set<Reservation> reservationList;

    public DBMemory() {
        this.reservationList = new HashSet<Reservation>();
    }

    public void addItem(Reservation item) {
        reservationList.add(item);
        System.out.println("reservationList = " + reservationList);
    }

    public Set<Reservation> getList() {
        System.out.println("reservationList = " + reservationList);
        return reservationList;

    }

    public void updateReservation(int id, Reservation reservation){
        Optional<Reservation> reservationFound = reservationList.stream().filter(r -> r.getId() == id).findFirst();
        if(reservationFound.isPresent()){
            reservationList.remove(reservationFound.get());
            reservationList.add(reservation);
            System.out.println("reservationList = " + reservationList);
        }
    }
}
