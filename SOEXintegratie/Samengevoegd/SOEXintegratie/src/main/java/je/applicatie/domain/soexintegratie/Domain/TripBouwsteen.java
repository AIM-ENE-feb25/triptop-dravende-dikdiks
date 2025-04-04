package je.applicatie.domain.soexintegratie.Domain;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TripBouwsteen implements Bouwsteen {
    private String name;
    private int lengthInKM;

    @Override
    public void setDetails(Map<String, String> details) {
        name = details.get("name");
        lengthInKM = Integer.parseInt(details.get("lengthInKM"));

        System.out.println("TripBouwsteen aangemaakt!");
        System.out.println("Naam: " + name + ", length in km: " + lengthInKM);
    }

    @Override
    public String getType() {
        return "";
    }

    @Override
    public String getDetails() {
        return "";
    }
}
