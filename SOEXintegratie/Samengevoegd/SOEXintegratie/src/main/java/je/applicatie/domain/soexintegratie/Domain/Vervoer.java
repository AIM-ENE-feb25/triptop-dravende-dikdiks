package je.applicatie.domain.soexintegratie.Domain;

import je.applicatie.domain.soexintegratie.Domain.Bouwsteen;

import java.util.Map;

public class Vervoer implements Bouwsteen {
    private final Map<String, Object> details;

    public Vervoer(Map<String, Object> details) {
        this.details = details;
    }

    @Override
    public void setDetails(Map<String, String> details) {
        this.details.putAll(details);
    }

    @Override
    public String getType() {
        return details.get("type").toString();
    }

    @Override
    public String getDetails() {
        return ("Details van Vervoer: " + details);
    }
}
