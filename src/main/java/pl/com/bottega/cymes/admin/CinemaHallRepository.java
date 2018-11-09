package pl.com.bottega.cymes.admin;

import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface CinemaHallRepository extends Repository<CinemaHall, UUID> {

    void save(CinemaHall cinemaHall);

    CinemaHall getOne(UUID hallId);
}
