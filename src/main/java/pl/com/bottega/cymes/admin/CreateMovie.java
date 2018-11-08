package pl.com.bottega.cymes.admin;

import pl.com.bottega.cymes.commons.Command;

import java.util.Set;
import java.util.UUID;

public class CreateMovie implements Command {

    public UUID movieId;
    public String title;
    public String description;
    public Set<String> genres;
    public Set<String> actors;

}
