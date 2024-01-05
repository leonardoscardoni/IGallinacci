package com.IGallinari.LastGame.service.API_to_DB;

import com.IGallinari.LastGame.repository.GameRepository;
import com.IGallinari.LastGame.repository.StatsGameRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
@AllArgsConstructor
public class DailyEndpoint {

    private ApiCaller apiCaller;

    private  RedirectJSON redirectJSON;

    private GameRepository gameRepository;

    private StatsGameRepository statsGameRepository;

    @PostConstruct
    public void makeDailyCall(){
        LocalDate today=LocalDate.now();
        System.out.println("Starting daily call");
        Integer season = 2023;
        Map<String, String> params;
        int totCall=0;
        int call=0;
        params = Map.ofEntries(
                Map.entry("league", "standard"),
                Map.entry("season", season.toString()));
        try {
            String response = apiCaller.callApi("games", params);
            call+=1;
            redirectJSON.manageJSON(response);
            TimeUnit.MINUTES.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("there were made "+call+" calls, total calls "+totCall);
        call=0;
        List<Integer> idGamesNotPlayed= gameRepository.findAllGameIdsBeforeDateNotPlayed(today);
        if (!idGamesNotPlayed.isEmpty()) {
            for (int idGame : idGamesNotPlayed) {
                List<Integer> idTeams = gameRepository.findIdTeam(idGame);
                for(Integer idTeam: idTeams){
                    System.out.println("idTeam: "+idTeam);
                    params = Map.ofEntries(
                            Map.entry("season", season.toString()),
                            Map.entry("team", idTeam.toString()));
                    try {
                        String response = apiCaller.callApi("players", params);//120 chiamate
                        call+=1;
                        redirectJSON.manageJSON(response);
                        TimeUnit.MINUTES.sleep(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        String response = apiCaller.callApi("players/statistics", params);//120 chiamate
                        call+=1;
                        redirectJSON.manageJSON(response);
                        TimeUnit.MINUTES.sleep(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    params = Map.ofEntries(
                            Map.entry("season", season.toString()),
                            Map.entry("id", idTeam.toString()));
                    try {
                        String response = apiCaller.callApi("teams/statistics", params);//120 chiamate
                        call+=1;
                        redirectJSON.manageJSON(response);
                        TimeUnit.MINUTES.sleep(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("there were made "+call+" calls, total calls "+totCall);
                call=0;
                Integer idGameInteger = idGame;
                params = Map.of("id", idGameInteger.toString());
                try {
                    String response = apiCaller.callApi("games/statistics", params);
                    call+=1;
                    redirectJSON.manageJSON(response);
                    TimeUnit.MINUTES.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("there were made "+call+" calls, total calls "+totCall);
            call=0;
            params = Map.ofEntries(
                    Map.entry("league", "standard"),
                    Map.entry("season", season.toString()));
            try {
                String response = apiCaller.callApi("standings", params);//2 chiamate
                call+=1;
                redirectJSON.manageJSON(response);
                TimeUnit.MINUTES.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("there were made "+call+" calls, total calls "+totCall);
        call=0;
        List<Integer> allIdGames = gameRepository.findAllGameIdsBeforeDate(today);
        List<Integer> idGamesInDB = statsGameRepository.findAllIdsWhereIsNotComplete();
        List<Integer> idGameNeed = new ArrayList<>(allIdGames);
        idGameNeed.removeAll(idGamesInDB);
        if(!idGameNeed.isEmpty()) {
            for (Integer idGame : idGameNeed) {
                params = Map.of("id", idGame.toString());
                try {
                    String response = apiCaller.callApi("games/statistics", params);
                    call+=1;
                    redirectJSON.manageJSON(response);
                    TimeUnit.MINUTES.sleep(1);
                } catch (Exception e) {
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
