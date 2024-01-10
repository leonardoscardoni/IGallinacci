
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
@Service
public class ApiCaller {
    private static final String RAPIDAPI_HOST = "v2.nba.api-sports.io";
    private static final String RAPIDAPI_KEY = "";
    private static final String baseURL = "https://v2.nba.api-sports.io/";

    private Integer countCall=0;

    private LocalTime firstCall=null;
    private static final HttpClient httpClient = HttpClient.newHttpClient();

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

    public String callApi(String endpoint, Map<String, String> params) {
        // Build the URI with query parameters
        String paramString = params.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .reduce((s1, s2) -> s1 + "&" + s2)
                .orElse("");

        URI uri = URI.create(baseURL + endpoint + "?" + paramString);

        try {
            if(firstCall==null){
                firstCall= LocalTime.now();
                countCall+=1;
            } else if (ChronoUnit.SECONDS.between(firstCall,LocalTime.now()) < 60 && countCall<10) {
                 countCall+=1;
            }else if (ChronoUnit.SECONDS.between(firstCall,LocalTime.now()) < 60 || countCall>=10) {
                System.out.println("LIMITE RAGGIUNTO time: "+ChronoUnit.SECONDS.between(firstCall,LocalTime.now())+" sec, countCall: "+countCall);
                TimeUnit.SECONDS.sleep(ChronoUnit.SECONDS.between(firstCall,LocalTime.now()));
                firstCall= LocalTime.now();
                countCall = 1;
            }else {
                firstCall=LocalTime.now();
                countCall=1;
            }
            System.out.println("time: "+ChronoUnit.SECONDS.between(firstCall,LocalTime.now())+" sec, countCall: "+countCall);
            // Make the API call and return the response
            System.out.println("Making a call to: "+endpoint+" endpoint");
            return makeApiCall(uri);
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Handle the error as needed
        }
    }
}