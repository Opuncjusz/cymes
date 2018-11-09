package pl.com.bottega.cymes.admin.adapters;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
import pl.com.bottega.cymes.admin.CreateShow;
import pl.com.bottega.cymes.admin.Movie;
import pl.com.bottega.cymes.admin.MovieRepository;
import pl.com.bottega.cymes.admin.Show;
import pl.com.bottega.cymes.admin.ShowRepository;
import pl.com.bottega.cymes.admin.UpdateCinema;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminEndpoints {

    private CinemaRepository cinemaRepository;
    private MovieRepository movieRepository;
    private CinemaHallRepository cinemaHallRepository;
    private ShowRepository showRepository;

    @PostMapping("/cinemas")
    @Transactional
    public void createCinema(@RequestBody CreateCinema createCinema) {
        Cinema cinema = Cinema.builder()
            .city(createCinema.city)
            .id(createCinema.cinemaId)
            .name(createCinema.name)
            .build();
        cinema = cinemaRepository.save(cinema);
    }

    @PutMapping("/cinemas")
    @Transactional
    public void updateCinema(@RequestBody UpdateCinema update) {
        Cinema cinema = cinemaRepository.findById(update.cinemaId);
        cinema.setCity(update.city);
        cinema.setName(update.name);
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

    @PostMapping("/cinemas/halls")
    @Transactional
    public void createHall(@RequestBody CreateCinemaHall cmd) {
        Cinema cinema = cinemaRepository.findById(cmd.cinemaId);
        CinemaHall cinemaHall = CinemaHall.builder()
            .cinema(cinema)
            .id(cmd.cinemaId)
            .name(cmd.hallName)
            .hallElements(mapHallElements(cmd.seats))
            .build();
        cinemaHallRepository.save(cinemaHall);
    }

    @PostMapping("/cinemas/shows")
    public void createShow(@RequestBody CreateShow createShow) {
        Show show = Show.builder()
            .cinemaHall(cinemaHallRepository.getOne(createShow.hallId))
            .id(createShow.showId)
            .movie(movieRepository.getOne(createShow.movieId))
            .pricing(createShow.pricing)
            .time(createShow.time)
            .build();
    }

    private Set<CinemaHall.HallElement> mapHallElements(String[][] seats) {
        Set<CinemaHall.HallElement> elements = new HashSet<>();
        int row = 0;
        for (String[] seatsRow : seats) {
            int col = 0;
            for (String seat : seatsRow) {
                elements.add(CinemaHall.HallElement.builder().nr(seat).row(row).col(col++).build());
            }
            row++;
        }
        return elements;
    }

}
