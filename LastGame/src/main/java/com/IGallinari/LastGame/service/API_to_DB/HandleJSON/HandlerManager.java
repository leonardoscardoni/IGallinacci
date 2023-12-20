package com.IGallinari.LastGame.service.API_to_DB.HandleJSON;

import com.IGallinari.LastGame.entity.StatsGame;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HandlerManager {
    private final GamesHandler gamesHandler;
    private final GamesStatisticsHandler gamesStatisticsHandler;
    private final PlayersHandler playersHandler;
    private final PlayersStatisticsHandler playersStatisticsHandler;
    private final StandingsHandler standingsHandler;
    private final TeamsHandler teamsHandler;
    private final TeamsStatisticsHandler teamsStatisticsHandler;


    public Handler getHandler(String endpoint) {

        switch (endpoint) {
            case "games":
                return gamesHandler;
            case "games/statistics":
                return gamesStatisticsHandler;
            case "players":
                return playersHandler;
            case "players/statistics":
                return playersStatisticsHandler;
            case "teams":
                return teamsHandler;
            case "teams/statistics":
                return teamsStatisticsHandler;
            case "standings":
                return standingsHandler;
            default:
                throw new RuntimeException();
        }
    }
}