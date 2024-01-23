
package com.IGallinari.LastGame.service.API_to_DB;

import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/**
 * Service class for making API calls to a specified URI.
 * Handles building and sending HTTP requests, and processing the responses.
 */
@Service
public class ApiCaller {
    private static final String RAPIDAPI_HOST = "v2.nba.api-sports.io";
    private static final String RAPIDAPI_KEY = "";
    private static final String baseURL = "https://v2.nba.api-sports.io/";

    private static final HttpClient httpClient = HttpClient.newHttpClient();
    /**
     * Makes an API call to the given URI.
     *
     * @param uri The URI to which the API call is made.
     * @return The response body as a String.
     * @throws Exception if there is an error during the API call.
     */
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
    /**
     * Calls an API endpoint using the provided endpoint and parameters.
     * Constructs the full URI and delegates the API call to the makeApiCall method.
     *
     * @param endpoint The API endpoint to call.
     * @param params The query parameters for the API call.
     * @return The response from the API call as a String, or null in case of an error.
     */
    public String callApi(String endpoint, Map<String, String> params) {
        // Build the URI with query parameters
        String paramString = params.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .reduce((s1, s2) -> s1 + "&" + s2)
                .orElse("");

        URI uri = URI.create(baseURL + endpoint + "?" + paramString);

        try {
            // Make the API call and return the response
            System.out.println("Making a call to: " + endpoint + " endpoint");
            return makeApiCall(uri);
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Handle the error as needed
        }
    }
}