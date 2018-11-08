package pl.com.bottega.cymes.admin;

import pl.com.bottega.cymes.commons.Command;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Map;
import java.util.UUID;

public class CreateShow implements Command {

    public UUID cinemaId;
    public Integer hallId;
    public Instant time;
    public Map<String, BigDecimal> pricing;
}
