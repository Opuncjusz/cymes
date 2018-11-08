package pl.com.bottega.cymes.admin;

import pl.com.bottega.cymes.commons.Command;

import java.util.UUID;

public class CreateCinemaHall implements Command {

    public UUID cinemaId;
    public UUID hallId;
    public String hallName;
    public String[][] seats;

}
