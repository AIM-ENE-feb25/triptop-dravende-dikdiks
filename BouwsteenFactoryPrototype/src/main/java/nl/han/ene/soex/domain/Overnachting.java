package nl.han.ene.soex.domain;

import java.util.Map;

public class Overnachting implements Bouwsteen {
    private final Map<String, Object> details;

    public Overnachting(Map<String, Object> details) {
        this.details = details;
    }
    @Override
    public String getType() {
        return details.get("type").toString();
    }

    @Override
    public String getDetails() {return ("Details van Overnachting: " + details);}
}
