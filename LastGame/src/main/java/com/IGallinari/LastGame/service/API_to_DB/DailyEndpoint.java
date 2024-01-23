package com.IGallinari.LastGame.service.API_to_DB;

import com.IGallinari.LastGame.repository.GameRepository;
import com.IGallinari.LastGame.repository.StatsGameRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/**
 * Class responsible for scheduling and executing daily API calls to gather
 * various data related to games, players, teams, and standings.
 */
@AllArgsConstructor
public class DailyEndpoint {

    private ApiCaller apiCaller;

    private  RedirectJSON redirectJSON;

    private GameRepository gameRepository;

    private StatsGameRepository statsGameRepository;
    /**
     * Scheduled method to run every day at 5 AM.
     * Initiates API calls for different data endpoints and manages the JSON response.
     *
     * @throws InterruptedException if the thread is interrupted while sleeping.
     */
    @Scheduled(cron = "0 0 5 * * *") //every day at 05:00:00
    public void init() throws InterruptedException {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        totCall+=call;
        System.out.println("there were made "+call+" calls, total calls "+totCall);
        call=0;
        TimeUnit.SECONDS.sleep(7);
        params = Map.ofEntries(
                Map.entry("league", "standard"),
                Map.entry("season", season.toString()));
        try {
            String response = apiCaller.callApi("standings", params);//2 chiamate
            call+=1;
            redirectJSON.manageJSON(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        totCall+=call;
        System.out.println("there were made "+call+" calls, total calls "+totCall);
        call=0;
        TimeUnit.SECONDS.sleep(7);
        List<Integer> idGamesNotCompleted= gameRepository.findAllGameIdsBeforeDateNotCompleted(today);
        List<Integer> idTeamAlreadyUpdate = new ArrayList<>();
        if (!idGamesNotCompleted.isEmpty()) {
            for (int idGame : idGamesNotCompleted) {
                List<Integer> idTeams = gameRepository.findIdTeam(idGame);
                for(Integer idTeam: idTeams){
                    if(!idTeamAlreadyUpdate.contains(idTeam)) {
                        System.out.println("idTeam: " + idTeam);
                        params = Map.ofEntries(
                                Map.entry("season", season.toString()),
                                Map.entry("team", idTeam.toString()));
                        try {
                            String response = apiCaller.callApi("players", params);//120 chiamate
                            call += 1;
                            redirectJSON.manageJSON(response);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        TimeUnit.SECONDS.sleep(7);
                        try {
                            String response = apiCaller.callApi("players/statistics", params);//120 chiamate
                            call += 1;
                            redirectJSON.manageJSON(response);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        TimeUnit.SECONDS.sleep(7);
                        params = Map.ofEntries(
                                Map.entry("season", season.toString()),
                                Map.entry("id", idTeam.toString()));
                        try {
                            String response = apiCaller.callApi("teams/statistics", params);//120 chiamate
                            call += 1;
                            redirectJSON.manageJSON(response);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        idTeamAlreadyUpdate.add(idTeam);
                        TimeUnit.SECONDS.sleep(7);
                    }
                    else{
                        System.out.println("idTeam: "+idTeam+" skipped because already up to date");
                    }
                }
                totCall+=call;
                System.out.println("there were made "+call+" calls, total calls "+totCall);
                call=0;
                Integer idGameInteger = idGame;
                params = Map.of("id", idGameInteger.toString());
                try {
                    String response = apiCaller.callApi("games/statistics", params);
                    call+=1;
                    redirectJSON.manageJSON(response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                TimeUnit.SECONDS.sleep(7);
            }
        }
        totCall+=call;
        System.out.println("there were made "+call+" calls, total calls "+totCall);
        call=0;
        List<Integer> idGameNeed = statsGameRepository.findAllIdsWhereIsNotComplete();
        if(!idGameNeed.isEmpty()) {
            for (Integer idGame : idGameNeed) {
                params = Map.of("id", idGame.toString());
                try {
                    String response = apiCaller.callApi("games/statistics", params);
                    call+=1;
                    redirectJSON.manageJSON(response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                TimeUnit.SECONDS.sleep(7);
            }
        }
        else {
            System.out.println("All game statistics have already been added");
        }
        totCall+=call;
        System.out.println("there were made "+call+" calls, total calls "+totCall);
    }
}
