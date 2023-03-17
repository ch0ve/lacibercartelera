package com.cinema.Cinema.ticket;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ticket {
    private String nameMovie;
    private int numSeat;
    private String movieTime;
    private String movieDate;
}