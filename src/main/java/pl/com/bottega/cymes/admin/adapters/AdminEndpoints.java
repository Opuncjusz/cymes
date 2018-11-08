package pl.com.bottega.cymes.admin.adapters;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.bottega.cymes.admin.Cinema;
import pl.com.bottega.cymes.admin.CinemaRepository;
import pl.com.bottega.cymes.admin.CreateCinema;
import pl.com.bottega.cymes.admin.CreateMovie;
import pl.com.bottega.cymes.admin.Movie;
import pl.com.bottega.cymes.admin.MovieRepository;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminEndpoints {

    private CinemaRepository cinemaRepository;
    private MovieRepository movieRepository;

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
    }

}
