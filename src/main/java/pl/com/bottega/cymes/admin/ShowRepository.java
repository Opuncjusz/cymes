package pl.com.bottega.cymes.admin;

import java.util.UUID;

import org.springframework.data.repository.Repository;


public interface ShowRepository extends Repository<Show, UUID> {

    void save(Show show);

}
