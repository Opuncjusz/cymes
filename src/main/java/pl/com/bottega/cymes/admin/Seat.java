package pl.com.bottega.cymes.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Seat {

    @ManyToOne
    private CinemaHall cinemaHall;
    private String row;
    private String number;
}
