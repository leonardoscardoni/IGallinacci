package com.IGallinari.LastGame.service.API_to_DB;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import com.IGallinari.LastGame.repository.*;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.Map;

public class PopulateDB {
    private ApiCaller apiCaller;

    private RedirectJSON redirectJSON;

    private GameRepository gameRepository;

    private TeamRepository teamRepository;

    private PlayerRepository playerRepository;

    private StatsPlayerRepository statsPlayerRepository;

    private StatsTeamRepository statsTeamRepository;

    private StatsGameRepository statsGameRepository;

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
        List<Integer> idTeamsInDB = playerRepository.findDistinctTeamIds();
        List<Integer> idTeamsNeed = new ArrayList<>(allIdTeams);
        idTeamsNeed.removeAll(idTeamsInDB);
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
        for (Integer season : seasons) {
            idTeamsInDB = statsPlayerRepository.findDistinctTeamIds(season);
            idTeamsNeed = new ArrayList<>(allIdTeams);
            idTeamsNeed.removeAll(idTeamsInDB);
            if (!idTeamsNeed.isEmpty()) {
                for (Integer idTeam : idTeamsNeed) {
                    params = Map.ofEntries(
                            Map.entry("season", season.toString()),
                            Map.entry("team", idTeam.toString()));
                    try {
                        String response = apiCaller.callApi("players/statistics", params);//120 chiamate
                        redirectJSON.manageJSON(response);
                        TimeUnit.MINUTES.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        for (Integer season : seasons) {
            idTeamsInDB = statsTeamRepository.findDistinctTeamIds(season);
            idTeamsNeed = new ArrayList<>(allIdTeams);
            idTeamsNeed.removeAll(idTeamsInDB);
            if (!idTeamsNeed.isEmpty()) {
                for (Integer idTeam : idTeamsNeed) {
                    params = Map.ofEntries(
                            Map.entry("season", season.toString()),
                            Map.entry("team", idTeam.toString()));
                    try {
                        String response = apiCaller.callApi("/teams/statistics", params);//120 chiamate
                        redirectJSON.manageJSON(response);
                        TimeUnit.MINUTES.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        LocalDate todayDate = LocalDate.now();
        List<Integer> allIdGames = gameRepository.findAllIdsBeforeDate(todayDate);
        List<Integer> idGamesInDB = statsGameRepository.findAllIds();
        List<Integer> idGameNeed = new ArrayList<>(allIdGames);
        idGameNeed.removeAll(idGamesInDB);
        if(!idGameNeed.isEmpty()) {
            for (Integer idGame : idGameNeed) {
                params = Map.of("id", idGame.toString());
                try {
                    String response = apiCaller.callApi("/teams/statistics", params);
                    redirectJSON.manageJSON(response);
                    TimeUnit.MINUTES.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

