package pl.com.bottega.cymes.admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Map;
import java.util.UUID;

//@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Show {

    @Id
    private UUID id;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private CinemaHall cinemaHall;

    private Instant time;

    private Map<String, BigDecimal> pricing;

}
