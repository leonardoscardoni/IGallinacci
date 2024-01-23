package com.IGallinari.LastGame.service.API_to_DB.HandleJSON;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
/**
 * Service class that manages different types of handlers.
 * Based on the provided endpoint, it determines and returns the appropriate handler.
 */
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

    /**
     * Retrieves the appropriate handler based on the given endpoint.
     *
     * @param endpoint The endpoint for which the handler is to be retrieved.
     * @return The handler corresponding to the given endpoint.
     * @throws RuntimeException if no handler is found for the given endpoint.
     */


    public Handler getHandler(String endpoint) {
        System.out.println(endpoint);
        switch (endpoint) {
            case "games/":
                System.out.println("Json redirected to the GamesHandeler");
                return gamesHandler;
            case "games/statistics":
                System.out.println("Json redirected to the GamesStatiscticHandeler");
                return gamesStatisticsHandler;
            case "players/":
                System.out.println("Json redirected to the PlayersHandeler");
                return playersHandler;
            case "players/statistics":
                System.out.println("Json redirected to the PlayersStatiscticHandeler");
                return playersStatisticsHandler;
            case "teams/":
                System.out.println("Json redirected to the TeamsHandeler");
                return teamsHandler;
            case "teams/statistics":
                System.out.println("Json redirected to the TeamsStatiscticHandeler");
                return teamsStatisticsHandler;
            case "standings/":
                System.out.println("Json redirected to the StandingsHandeler");
                return standingsHandler;
            default:
                throw new RuntimeException();
        }
    }
}