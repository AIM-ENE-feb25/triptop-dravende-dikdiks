package nl.han.sw.bewd;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Main {
    public static void main(String[] args) throws UnirestException {
        // Gebruik de juiste HttpResponse van Unirest
        HttpResponse<String> response = Unirest.get("https://sky-scrapper.p.rapidapi.com/api/v1/flights/searchAirport?query=new&locale=en-US")
                .header("x-rapidapi-key", "55e0eb01d0msh5e46ab40f470790p1123a4jsnbca6ffde3cfa")
                .header("x-rapidapi-host", "sky-scrapper.p.rapidapi.com")
                .asString();

        // Print de response body om te testen
        System.out.println(response.getBody());
    }
}
