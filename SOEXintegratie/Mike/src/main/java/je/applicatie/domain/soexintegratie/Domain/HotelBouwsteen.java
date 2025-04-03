package je.applicatie.domain.soexintegratie.Domain;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
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
        System.out.println("Naam: " + name + ", stad: " + city + ", Duratie in dagen: " + durationInDays);
    }


}
