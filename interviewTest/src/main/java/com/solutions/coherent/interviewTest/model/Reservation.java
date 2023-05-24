package com.solutions.coherent.interviewTest.model;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation implements Serializable {

    private int id;
    private String clientFullName;
    private int roomNumber;
    private List<LocalDate> reservationDates;


}
