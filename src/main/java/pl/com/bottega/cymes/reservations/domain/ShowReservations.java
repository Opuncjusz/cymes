package pl.com.bottega.cymes.reservations.domain;

import lombok.Value;
import pl.com.bottega.cymes.reservations.domain.commands.SelectSeats;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ShowReservations {

    private UUID showId;

    private Map<Seat, UUID> occupiedSeats = new HashMap<>();

    public ShowReservations(UUID showId) {
        this.showId = showId;
    }

    public void export(ShowReservationsExporter exporter) {
        exporter.addShowId(showId);
    }

    public void selectSeats(SelectSeats selectSeats) {

    }
}

@Value
class Seat {
    private int row;
    private int col;
}
