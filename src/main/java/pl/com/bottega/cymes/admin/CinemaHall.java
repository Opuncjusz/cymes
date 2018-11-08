package pl.com.bottega.cymes.admin;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CinemaHall {

    @Id
    private UUID id;

    @ManyToOne
    private Cinema cinema;

    private String hallName;

    @OneToMany
    private List<Seat> seats;

}
