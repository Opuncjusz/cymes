package pl.com.bottega.cymes.e2e;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import pl.com.bottega.cymes.admin.Cinema;
import pl.com.bottega.cymes.admin.CreateCinema;
import pl.com.bottega.cymes.admin.CreateCinemaHall;
import pl.com.bottega.cymes.admin.CreateMovie;
import pl.com.bottega.cymes.admin.CreateShow;

import javax.persistence.EntityManager;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class SeatSelectionTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private EntityManager entityManager;

    private UUID cinemaId = UUID.randomUUID();
    private UUID movieId = UUID.randomUUID();
    private UUID hallId = UUID.randomUUID();
    private UUID showId = UUID.randomUUID();

    @Test
    public void cantMakeReservationOfTheSameSeatTwice() {
        // given
        restTemplate.postForEntity("http://localhost:8080/admin/cinemas", createCinema(), Void.class);
        restTemplate.postForEntity("http://localhost:8080/admin/movies", createMovie(), Void.class);
        restTemplate.postForEntity("http://localhost:8080/admin/cinemas/halls", createCinemaHall(), Void.class);
        restTemplate.postForEntity("http://localhost:8080/admin/cinemas/shows", createShow(), Void.class);

        // when

        // then
        Cinema cinema = entityManager.find(Cinema.class, cinemaId);
        assertThat(cinema).isNotNull();
    }

    private CreateShow createShow() {
        CreateShow createShow = new CreateShow();
        createShow.movieId = movieId;
        createShow.hallId = hallId;
        createShow.showId = showId;
        createShow.time = Instant.now().plus(1L, ChronoUnit.DAYS);
        return createShow;
    }

    private CreateCinemaHall createCinemaHall() {
        CreateCinemaHall createCinemaHall = new CreateCinemaHall();
        createCinemaHall.cinemaId = cinemaId;
        createCinemaHall.hallId = hallId;
        createCinemaHall.seats = new String[][]{
            new String[]{"1", "2", ""},
            new String[]{"1", "2", ""},
            new String[]{"1", "2", "3"}
        };
        createCinemaHall.hallName = "VIP Room";
        return createCinemaHall;
    }

    private CreateMovie createMovie() {
        CreateMovie createMovie = new CreateMovie();
        createMovie.title = "Kler";
        createMovie.actors = new HashSet<>();
        createMovie.actors.add("Gajos");
        createMovie.genres = new HashSet<>();
        createMovie.genres.add("Drama");
        createMovie.genres.add("Komedia");
        createMovie.description = "dobra beka";
        createMovie.movieId = movieId;
        return createMovie;
    }

    private CreateCinema createCinema() {
        CreateCinema createCinema = new CreateCinema();
        createCinema.cinemaId = cinemaId;
        createCinema.city = "Wroclaw";
        createCinema.name = "Magnolia";
        return createCinema;
    }

}
