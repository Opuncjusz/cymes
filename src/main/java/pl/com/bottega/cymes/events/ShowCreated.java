package pl.com.bottega.cymes.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.com.bottega.cymes.commons.Event;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class ShowCreated implements Event {

    private UUID showId;

}
