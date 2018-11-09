package pl.com.bottega.cymes.reservations.domain;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import pl.com.bottega.cymes.events.ShowCreated;

@Component
@AllArgsConstructor
public class ShowCreatedHandler {

    private ShowReservationsRepository showReservationsRepository;

    public void handle(ShowCreated showCreated) {
        ShowReservations showReservations = new ShowReservations(showCreated.getShowId());
        showReservationsRepository.save(showReservations);
    }
}
