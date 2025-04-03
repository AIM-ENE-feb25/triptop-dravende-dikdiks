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

    @Value("${bookingcom.key}")
    private String apiKey;
    @Value("${bookingcom.host}")
    private String apiHost;
    @Value("${bookingcom.url}")
    private String apiUrl;

    @Override
    public String fetchData(String param) {
        HttpHeaders headers = new HttpHeaders();

        headers.set("x-rapidapi-key", apiKey);
        headers.set("x-rapidapi-host", apiHost);


        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, String.class);

        return response.getBody();

    }
}
