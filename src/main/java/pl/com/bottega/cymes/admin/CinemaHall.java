package pl.com.bottega.cymes.admin;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Cascade(CascadeType.ALL)
    @OneToMany(mappedBy = "cinemaHall")
    @Setter
    private List<Seat> seats;

}
