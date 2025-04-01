package je.applicatie.domain.soexintegratie.Adapters;

import je.applicatie.domain.soexintegratie.Interfaces.ExternalServicesInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class BookincomAdapter implements ExternalServicesInterface {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String serviceUrl = "https://booking-com.p.rapidapi.com/v1/hotels/map-markers?locale=en-gb&hotel_id=1676161";

    @Value("${rapidapi.key}")
    private String apiKey;
    @Value("${rapidapi.host}")
    private String apiHost;

    @Override
    public String fetchData(String param) {
        HttpHeaders headers = new HttpHeaders();

        headers.set("x-rapidapi-key", apiKey);
        headers.set("x-rapidapi-host", apiHost);


        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(serviceUrl, HttpMethod.GET, entity, String.class);

        return response.getBody();

    }
}
