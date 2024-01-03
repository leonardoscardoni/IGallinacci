package com.IGallinari.LastGame.service.API_to_DB;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class DailyEndpoint {

    private ApiCaller apiCaller;

    private  RedirectJSON redirectJSON;

    public void makeDailyCall(){
        System.out.println("Starting daily call");
        Integer season = 2023;
        Map<String, String> params;
        int totCall=0;
        int call=0;
        params = Map.ofEntries(
                Map.entry("league", "standard"),
                Map.entry("season", season.toString()));
        try {
            String response = apiCaller.callApi("games", params);//2 chiamate
            call+=1;
            redirectJSON.manageJSON(response);
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException | JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("there were made "+call+" calls, total calls "+totCall);
        call=0;
        List<Integer> allIdTeams = teamRepository.findAllIds();
    }

}
