package pl.com.bottega.cymes.admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(indexes = {
    @Index(columnList = "name, city", unique = true)
})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Cinema {

    @Id
    private UUID id;
    private String name;
    private String city;

    @OneToMany
    Set<CinemaHall> cinemaHalls;
}
