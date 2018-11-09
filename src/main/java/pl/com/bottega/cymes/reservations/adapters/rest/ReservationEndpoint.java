package pl.com.bottega.cymes.reservations.adapters.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.bottega.cymes.reservations.domain.commands.SelectSeats;
import pl.com.bottega.cymes.reservations.domain.commands.SelectShow;

@RestController
@RequestMapping("/reservations")
public class ReservationEndpoint {


    @PostMapping
    public void create(SelectShow selectShow) {

    }

    @PostMapping("/seats")
    public void selectSeats(SelectSeats selectSeats) {

    }

}
