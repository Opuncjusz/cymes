package pl.com.bottega.cymes.admin;

import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface MovieRepository extends Repository<Movie, UUID> {

    void save(Movie movie);

}
