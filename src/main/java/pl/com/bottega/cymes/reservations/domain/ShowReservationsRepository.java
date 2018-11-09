package pl.com.bottega.cymes.reservations.domain;

import java.util.UUID;

public interface ShowReservationsRepository {

    void save(ShowReservations showReservations);

    ShowReservations get(UUID uuid);
}
