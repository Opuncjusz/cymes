package pl.com.bottega.cymes.reservations.domain;

import java.util.UUID;

public class ShowReservations {

    private UUID showId;

    public ShowReservations(UUID showId) {
        this.showId = showId;
    }

    public void export(ShowReservationsExporter exporter) {
        exporter.addShowId(showId);
    }

}
