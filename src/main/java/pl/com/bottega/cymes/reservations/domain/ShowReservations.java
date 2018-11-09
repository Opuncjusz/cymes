package pl.com.bottega.cymes.reservations.domain;


import java.util.UUID;


public class ShowReservations {

    public ShowReservations(UUID showId) {
        this.showId = showId;
    }

    private UUID showId;

    public void export(ShowReservationsExporter exporter) {
        exporter.addShowId(showId);
    }
}
