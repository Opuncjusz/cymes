package pl.com.bottega.cymes.reservations.domain.handlers;

import pl.com.bottega.cymes.reservations.domain.Reservation;
import pl.com.bottega.cymes.reservations.domain.ReservationRepository;
import pl.com.bottega.cymes.reservations.domain.ShowReservations;
import pl.com.bottega.cymes.reservations.domain.ShowReservationsRepository;
import pl.com.bottega.cymes.reservations.domain.commands.SelectSeats;

public class SelectSeatsHandler {

    private ReservationRepository reservationRepository;
    private ShowReservationsRepository showReservationsRepository;

    public void handle(SelectSeats selectSeats) {
        Reservation reservation = reservationRepository.get(selectSeats.reservationId);
        ShowReservations showReservations = showReservationsRepository.get(reservation.showId());
        showReservations.selectSeats(selectSeats);
    }

}
