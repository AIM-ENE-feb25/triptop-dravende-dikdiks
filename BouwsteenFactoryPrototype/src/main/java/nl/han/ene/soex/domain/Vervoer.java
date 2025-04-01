package nl.han.ene.soex.domain;

import java.util.Map;

public class Vervoer implements Bouwsteen {
    private final Map<String, Object> details;

    public Vervoer(Map<String, Object> details) {
        this.details = details;
    }

    @Override
    public String getType() {
        return details.get("type").toString();
    }

    @Override
    public String toonDetails() {
        return ("Details van Vervoer: " + details);
    }
}
