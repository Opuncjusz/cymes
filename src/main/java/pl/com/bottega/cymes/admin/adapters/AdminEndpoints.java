package pl.com.bottega.cymes.admin.adapters;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.bottega.cymes.admin.Cinema;
import pl.com.bottega.cymes.admin.CinemaHall;
import pl.com.bottega.cymes.admin.CinemaHallRepository;
import pl.com.bottega.cymes.admin.CinemaRepository;
import pl.com.bottega.cymes.admin.CreateCinema;
import pl.com.bottega.cymes.admin.CreateCinemaHall;
import pl.com.bottega.cymes.admin.CreateMovie;
import pl.com.bottega.cymes.admin.Movie;
import pl.com.bottega.cymes.admin.MovieRepository;
import pl.com.bottega.cymes.admin.Seat;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminEndpoints {

    private CinemaRepository cinemaRepository;
    private MovieRepository movieRepository;
    private CinemaHallRepository cinemaHallRepository;

    @PostMapping("/cinemas")
    @Transactional
    public void createCinema(@RequestBody CreateCinema createCinema) {
        Cinema cinema = Cinema.builder()
            .city(createCinema.city)
            .id(createCinema.cinemaId)
            .name(createCinema.name)
            .build();
        cinemaRepository.save(cinema);
    }

    @PostMapping("/movies")
    @Transactional
    public void createMovie(@RequestBody CreateMovie createMovie) {
        Movie movie = Movie.builder()
            .movieId(createMovie.movieId)
            .title(createMovie.title)
            .description(createMovie.description)
            .actors(createMovie.actors)
            .genres(createMovie.genres)
            .build();
        movieRepository.save(movie);
    }

    @PostMapping("/cinemaHall")
    @Transactional
    public void createCinemaHall(@RequestBody CreateCinemaHall createCinemaHall){
        CinemaHall cinemaHall = CinemaHall.builder()
                .id(createCinemaHall.hallId)
                .hallName(createCinemaHall.hallName)
                .cinema(cinemaRepository.findById(createCinemaHall.cinemaId))
                .build();
        cinemaHall.setSeats(createSeats(createCinemaHall.seats, cinemaHall));
        cinemaHallRepository.save(cinemaHall);


    }

    private List<Seat> createSeats(String [][] seats, CinemaHall cinemaHall){
        List<Seat> seatsList = new ArrayList<>();
        for (int i = 0; i < seats.length; i++){
            for (String number : seats[i]) {
                seatsList.add(Seat.builder().row(i+"").number(number).cinemaHall(cinemaHall).build());
            }
        }
        return seatsList;
    }
}
