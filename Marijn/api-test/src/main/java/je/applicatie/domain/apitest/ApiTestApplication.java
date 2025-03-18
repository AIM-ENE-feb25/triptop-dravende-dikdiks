package je.applicatie.domain.apitest;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiTestApplication.class, args);

        HttpResponse<String> response = Unirest.get("https://booking-com15.p.rapidapi.com/api/v1/attraction/getAttractionReviews")
                .queryString("id", "PR6K7ZswbGBs")
                .queryString("page", "1")
                .header("x-rapidapi-host", "booking-com15.p.rapidapi.com")
                .header("x-rapidapi-key", "91c1fdc560msh2a0d7b58c228e7dp1f0cf2jsn59334af69949")
                .asString();

        System.out.println(response.getBody());
    }
}
