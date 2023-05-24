package com.solutions.coherent.interviewTest.controller;

import com.solutions.coherent.interviewTest.model.Reservation;
import com.solutions.coherent.interviewTest.service.ReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "/coherent/solutions", produces =  "application/json")
public class ReservationController {

    @Autowired
    private ReservationServiceImpl reservationService;

    @PostMapping("/add")
    public ResponseEntity<?> addReservation(@RequestBody Reservation reservation){
        reservationService.createReservation(reservation);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getReservations(){
        Set<Reservation> reservations = reservationService.getReservation();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateReservation(@PathVariable int id, @RequestBody Reservation reservation){
        reservationService.updateReservationById(id, reservation);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
