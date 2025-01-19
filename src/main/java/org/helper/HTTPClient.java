package org.helper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HTTPClient {

    public String executeTranslate(String data) throws IOException, InterruptedException {

        String requestData = "{\"from\":\"es\",\"to\":\"en\",\"q\":\"" + data +"\"}";

        URI uri = URI.create("https://rapid-translate-multi-traduction.p.rapidapi.com/t");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-Type", "application/json")
                .header("x-rapidapi-host", "rapid-translate-multi-traduction.p.rapidapi.com")
                .header("x-rapidapi-key", System.getenv("RAPIDAPI_KEY"))
                .POST(HttpRequest.BodyPublishers.ofString(requestData))
                .build();
        HttpResponse<?> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body().toString();

    }
}
