package pl.com.bottega.cymes.admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CinemaHall {

    @Id
    private UUID id;

    @ManyToOne
    private Cinema cinema;

    private String name;

    @ElementCollection
    private Set<HallElement> hallElements = new HashSet<>();

    @Embeddable
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class HallElement {

        private Integer row;
        private Integer col;
        private String nr;

    }

}