package pl.com.bottega.cymes.reservations.adapters.listeners;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import pl.com.bottega.cymes.events.ShowCreated;
import pl.com.bottega.cymes.reservations.domain.ShowCreatedHandler;

@Component
@AllArgsConstructor
public class ShowCreatedListener {

    private ShowCreatedHandler showCreatedHandler;

    @EventListener
    public void handleShowCreated(ShowCreated showCreated) {
        showCreatedHandler.handle(showCreated);
    }
}
