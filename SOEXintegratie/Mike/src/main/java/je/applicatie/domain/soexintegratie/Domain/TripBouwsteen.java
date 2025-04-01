package je.applicatie.domain.soexintegratie.Domain;

import java.util.Map;

public class TripBouwsteen implements Bouwsteen {
    private String name;
    private int lengthInKM;

    @Override
    public void setDetails(Map<String, String> details) {
        name = details.get("name");
        lengthInKM = Integer.parseInt(details.get("lengthInKM"));

        System.out.println("TripBouwsteen aangemaakt!");
        System.out.println(STR."Naam: \{name}\nLength in KM: \{lengthInKM}");
    }
}
