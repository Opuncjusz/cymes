package pl.com.bottega.cymes.reservations.adapters.listeners;

import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.com.bottega.cymes.events.ShowCreated;
import pl.com.bottega.cymes.reservations.domain.ShowCreatedHandler;

@Component
@AllArgsConstructor
public class ShowCreatedListener {

    private ShowCreatedHandler handler;

    @EventListener
    public void handleShowCreated(ShowCreated event) {
        handler.handle(event);
    }

}
