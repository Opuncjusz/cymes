package pl.com.bottega.cymes.reservations.domain.commands;

import pl.com.bottega.cymes.commons.Command;

import java.util.Set;
import java.util.UUID;

public class SelectSeats implements Command {

    public UUID reservationId;
    public Set<Seat> seats;

    public static class Seat {
        public int row;
        public int col;
    }

}
