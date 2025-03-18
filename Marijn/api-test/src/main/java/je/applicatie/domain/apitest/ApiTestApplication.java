package je.applicatie.domain.apitest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
public class ApiTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiTestApplication.class, args);

        // API call logic should go inside main or in a method
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://booking-com15.p.rapidapi.com/api/v1/attraction/getAttractionReviews?id=PR6K7ZswbGBs&page=1"))
                .header("x-rapidapi-host", "booking-com15.p.rapidapi.com")
                .header("x-rapidapi-key", "91c1fdc560msh2a0d7b58c228e7dp1f0cf2jsn59334af69949")
                .GET()
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }
}
