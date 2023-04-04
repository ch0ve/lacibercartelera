package com.cinema.Cinema.entities;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Data
@NoArgsConstructor
@Entity
public class Ticket {
    private long idMovie;
    private int numSeat;
    public String nameMovie;
    private String movieTime;
    private String movieDate;
    @Id
    private long idTicket; // Count the  numbers of tickets a user buy by movie


    public Ticket(long idMovie, int numSeat, String movieTime, String movieDate) {
        this.idMovie = idMovie;
        this.numSeat = numSeat;
        this.movieTime = movieTime;
        this.movieDate = movieDate;
    }


}
