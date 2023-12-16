
package com.IGallinari.LastGame.service.API_to_DB;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ApiCaller {
    private static final String RAPIDAPI_HOST = "v2.nba.api-sports.io";
    private static final String RAPIDAPI_KEY = "4c64ae58903b6076d0249d712d55ee29";
    private static final String baseURL = "https://v2.nba.api-sports.io/";

    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private final String endpoint;
    private final Map<String, String> params;

    public ApiCaller(String endpoint, Map<String, String> params) {
        this.endpoint = endpoint;
        this.params = params;
    }

    private String makeApiCall(URI uri) throws Exception {
        // Build the HTTP request with headers
        HttpRequest request = HttpRequest.newBuilder(uri)
                .header("x-rapidapi-host", RAPIDAPI_HOST)
                .header("x-rapidapi-key", RAPIDAPI_KEY)
                .GET()
                .build();

        // Send the HTTP request and get the response
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public String makeApiCall() {
        // Build the URI with query parameters
        String paramString = params.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .reduce((s1, s2) -> s1 + "&" + s2)
                .orElse("");

        URI uri = URI.create(baseURL + endpoint + "?" + paramString);

        try {
            // Make the API call and return the response
            return makeApiCall(uri);
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Handle the error as needed
        }
    }
}