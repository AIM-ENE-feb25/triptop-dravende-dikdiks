package nl.han.se.soex;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        AsyncHttpClient client = new DefaultAsyncHttpClient();
        client.prepare("GET", "https://tripadvisor-com1.p.rapidapi.com/restaurants/search?geoId=1954828&units=miles&sortType=asc")
                .setHeader("x-rapidapi-key", "91c1fdc560msh2a0d7b58c228e7dp1f0cf2jsn59334af69949")
                .setHeader("x-rapidapi-host", "tripadvisor-com1.p.rapidapi.com")
                .execute()
                .toCompletableFuture()
                .thenAccept(System.out::println)
                .join();

        client.close();



    }
}