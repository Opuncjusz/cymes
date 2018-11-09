package pl.com.bottega.cymes.admin;

import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface ShowRepository extends Repository<Show, UUID> {

    void save(Show show);

}
