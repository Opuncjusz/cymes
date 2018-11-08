package pl.com.bottega.cymes.admin;

import java.util.UUID;

import org.springframework.data.repository.Repository;

public interface CinemaHallRepository extends Repository<CinemaHall, UUID> {
    void save(CinemaHall cinemaHall);
    CinemaHall findById(UUID id);
}
