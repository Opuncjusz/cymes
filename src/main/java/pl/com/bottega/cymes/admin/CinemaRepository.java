package pl.com.bottega.cymes.admin;

import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface CinemaRepository extends Repository<Cinema, UUID> {

    Cinema save(Cinema cinema);

    Cinema findById(UUID id);

}
