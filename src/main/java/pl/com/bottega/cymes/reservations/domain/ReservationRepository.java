package pl.com.bottega.cymes.reservations.domain;

import java.util.UUID;

public interface ReservationRepository {

    void save(Reservation reservation);

    Reservation get(UUID reservationId);
}
