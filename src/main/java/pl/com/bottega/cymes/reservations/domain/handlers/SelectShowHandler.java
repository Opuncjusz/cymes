package pl.com.bottega.cymes.reservations.domain.handlers;

import pl.com.bottega.cymes.reservations.domain.Reservation;
import pl.com.bottega.cymes.reservations.domain.ReservationRepository;
import pl.com.bottega.cymes.reservations.domain.commands.SelectShow;

public class SelectShowHandler {

    private ReservationRepository reservationRepository;

    public void handle(SelectShow selectShow) {
        Reservation reservation = new Reservation(selectShow);
        reservationRepository.save(reservation);
    }

}
