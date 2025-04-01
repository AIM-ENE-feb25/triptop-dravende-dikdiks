package je.applicatie.domain.soexintegratie.Domain;

import java.util.Map;

public class HotelBouwsteen implements Bouwsteen {
    private String name;
    private String city;
    private int durationInDays;

    @Override
    public void setDetails(Map<String, String> details) {
        name = details.get("name");
        city = details.get("city");
        durationInDays = Integer.parseInt(details.get("durationInDays"));

        System.out.println("HotelBouwsteen aangemaakt!");
        System.out.println(STR."Naam: \{name}\nStad: \{city}\nDuratie in dagen: \{durationInDays}");
    }
}
