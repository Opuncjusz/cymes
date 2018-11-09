package pl.com.bottega.cymes.reservations.domain;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.com.bottega.cymes.events.ShowCreated;

@Component
@AllArgsConstructor
public class ShowCreatedHandler {

    private ShowReservationsRepository repository;

    public void handle(ShowCreated showCreated) {
        ShowReservations showReservations = new ShowReservations(showCreated.getShowId());
        repository.save(showReservations);
    }

}
