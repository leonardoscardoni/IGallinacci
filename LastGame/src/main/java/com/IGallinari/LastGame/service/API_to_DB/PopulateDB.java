package com.IGallinari.LastGame.service.API_to_DB;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import com.IGallinari.LastGame.repository.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@AllArgsConstructor
public class PopulateDB {
    private ApiCaller apiCaller;

    private RedirectJSON redirectJSON;

    private GameRepository gameRepository;

    private TeamRepository teamRepository;

    private PlayerRepository playerRepository;

    private StatsPlayerRepository statsPlayerRepository;

    private StatsTeamRepository statsTeamRepository;

    private StatsGameRepository statsGameRepository;

    @PostConstruct
    public void init() throws JsonProcessingException {
        int totCall=0;
        int call=0;
        Map<String, String> params;
        System.out.println("Start of database population");
        if(teamRepository.count() <60 ) {//check if the team is full
            System.out.println("Preparing the call for the /teams endpoint");
            //prepare the call for the /teams endpoint
            params = Map.of("league", "standard");
            try {
                String response = apiCaller.callApi("teams", params);//1 chiamata
                call+=1;
                redirectJSON.manageJSON(response);
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("All teams have already been added");
        }
        totCall+=call;
        System.out.println("there were made "+call+" calls, total calls "+totCall);
        call=0;
        //prepare the call for the /games endpoint
        List<Integer> yearsInDB= gameRepository.findDistinctYears();
        List<Integer> seasons = Arrays.asList(2022, 2023);
        List<Integer> yearsNeed = new ArrayList<>(seasons);
        yearsNeed.removeAll(yearsInDB);
        if (!yearsNeed.isEmpty()) {
            System.out.println("Preparing the call/s for the /games endpoint");
            for (Integer season : yearsNeed) {
                params = Map.ofEntries(
                        Map.entry("league", "standard"),
                        Map.entry("seasons", season.toString()));
                try {
                    String response = apiCaller.callApi("games", params);//2 chiamate
                    call+=1;
                    redirectJSON.manageJSON(response);
                    TimeUnit.MINUTES.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else {
            System.out.println("All games have already been added");
        }
        totCall+=call;
        System.out.println("there were made "+call+" calls, total calls "+totCall);
        call=0;
        List<Integer> allIdTeams = gameRepository.findDistinctIdTeams();
        List<Integer> idTeamsInDB = playerRepository.findDistinctTeamIds();
        List<Integer> idTeamsNeed = new ArrayList<>(allIdTeams);
        idTeamsNeed.removeAll(idTeamsInDB);
        if (!idTeamsNeed.isEmpty()) {
            System.out.println("Preparing the call/s for the /players endpoint");
            for (Integer season : seasons) {
                for (Integer idTeam : idTeamsNeed) {
                    params = Map.ofEntries(
                            Map.entry("season", season.toString()),
                            Map.entry("team", idTeam.toString()));
                    try {
                        String response = apiCaller.callApi("players", params);//120 chiamate
                        call+=1;
                        redirectJSON.manageJSON(response);
                        TimeUnit.MINUTES.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        else {
            System.out.println("All players have already been added");
        }
        totCall+=call;
        System.out.println("there were made "+call+" calls, total calls "+totCall);
        call=0;
        for (Integer season : seasons) {
            idTeamsInDB = statsPlayerRepository.findDistinctTeamIds(season);
            idTeamsNeed = new ArrayList<>(allIdTeams);
            idTeamsNeed.removeAll(idTeamsInDB);
            if (!idTeamsNeed.isEmpty()) {
                System.out.println("Preparing the call/s for the /players/statistics endpoint");
                for (Integer idTeam : idTeamsNeed) {
                    params = Map.ofEntries(
                            Map.entry("season", season.toString()),
                            Map.entry("team", idTeam.toString()));
                    try {
                        String response = apiCaller.callApi("players/statistics", params);//120 chiamate
                        call+=1;
                        redirectJSON.manageJSON(response);
                        TimeUnit.MINUTES.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("All player statistics, of the season: "+season+", have already been added");
            }
        }
        totCall+=call;
        System.out.println("there were made "+call+" calls, total calls "+totCall);
        call=0;
        for (Integer season : seasons) {
            idTeamsInDB = statsTeamRepository.findDistinctTeamIds(season);
            idTeamsNeed = new ArrayList<>(allIdTeams);
            idTeamsNeed.removeAll(idTeamsInDB);
            if (!idTeamsNeed.isEmpty()) {
                System.out.println("Preparing the call/s for the /teams/statistics endpoint");
                for (Integer idTeam : idTeamsNeed) {
                    params = Map.ofEntries(
                            Map.entry("season", season.toString()),
                            Map.entry("team", idTeam.toString()));
                    try {
                        String response = apiCaller.callApi("teams/statistics", params);//120 chiamate
                        call+=1;
                        redirectJSON.manageJSON(response);
                        TimeUnit.MINUTES.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }else {
                System.out.println("All team statistics, of the season: "+season+", have already been added");
            }

        }
        totCall+=call;
        System.out.println("there were made "+call+" calls, total calls"+totCall);
        call=0;
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
                    call+=1;
                    redirectJSON.manageJSON(response);
                    TimeUnit.MINUTES.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        else {
            System.out.println("All game statistics have already been added");
        }
        totCall+=call;
        System.out.println("there were made "+call+" calls, total calls "+totCall);
    }
}

