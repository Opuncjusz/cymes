package pl.com.bottega.cymes.reservations.domain;

import pl.com.bottega.cymes.reservations.domain.commands.SelectShow;

import java.util.UUID;

public class Reservation {

    private final UUID showId;
    private final UUID reservationId;

    public Reservation(SelectShow selectShow) {
        this.reservationId = selectShow.reservationId;
        this.showId = selectShow.showId;
    }

    public UUID showId() {
        return showId;
    }
}
