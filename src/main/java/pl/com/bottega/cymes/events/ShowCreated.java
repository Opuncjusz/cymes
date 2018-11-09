package pl.com.bottega.cymes.events;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.com.bottega.cymes.commons.Event;

@AllArgsConstructor
@Getter
public class ShowCreated implements Event {

    private UUID showId;
}
