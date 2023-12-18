package com.IGallinari.LastGame.service.API_to_DB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import com.IGallinari.LastGame.repository.GameRepository;
import com.IGallinari.LastGame.repository.TeamRepository;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.Map;

public class PopulateDB {
    private ApiCaller apiCaller;

    private RedirectJSON redirectJSON;

    private GameRepository gameRepository;

    private TeamRepository teamRepository;

    public void PopulateDB() throws JsonProcessingException {

        Map<String, String> params;
        if(teamRepository.findAll().isEmpty()) {//check if the team is empty
            //prepare the call for the /teams endpoint
            params = Map.of("league", "standard");
            try {
                String response = apiCaller.callApi("teams", params);//1 chiamata
                redirectJSON.manageJSON(response);
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //pepare the call for the /games endpoint
        List<Integer> yearsInDB= gameRepository.findDistinctYears();
        List<Integer> seasons = Arrays.asList(2022, 2023);
        List<Integer> yearsNeed = new ArrayList<>(seasons);
        yearsNeed.removeAll(yearsInDB);
        if (!yearsNeed.isEmpty()) {
            for (Integer season : yearsNeed) {
                params = Map.ofEntries(
                        Map.entry("league", "standard"),
                        Map.entry("seasons", season.toString()));
                try {
                    String response = apiCaller.callApi("games", params);//2 chiamate
                    redirectJSON.manageJSON(response);
                    TimeUnit.MINUTES.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        List<Integer> allIdTeams = gameRepository.findDistinctIdTeams();
        List<Integer> idTeamsInDB = teamRepository.findAllIds();
        List<Integer> idTeamsNeed = new ArrayList<>(allIdTeams);
        yearsNeed.removeAll(idTeamsInDB);
        if (!idTeamsNeed.isEmpty()) {
            for (Integer season : seasons) {
                for (Integer idTeam : idTeamsNeed) {
                    params = Map.ofEntries(
                            Map.entry("season", season.toString()),
                            Map.entry("team", idTeam.toString()));
                    try {
                        String response = apiCaller.callApi("players", params);//120 chiamate
                        redirectJSON.manageJSON(response);
                        TimeUnit.MINUTES.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
