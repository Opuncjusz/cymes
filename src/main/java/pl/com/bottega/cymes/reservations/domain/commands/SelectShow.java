package pl.com.bottega.cymes.reservations.domain.commands;

import pl.com.bottega.cymes.commons.Command;

import java.util.UUID;

public class SelectShow implements Command {

    public UUID showId;
    public UUID reservationId;

}
