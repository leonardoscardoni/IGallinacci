package com.IGallinari.LastGame.service.API_to_DB;

import com.IGallinari.LastGame.service.API_to_DB.HandleJSON.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
public class RedirectJSON {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void manageJSON(String jsonString) throws JsonProcessingException {
        JsonNode jsonNode = objectMapper.readTree(jsonString);
        String endpoint = jsonNode.get("get").asText();

        switch (endpoint) {
            case "games/":
                GamesHandler gamesHandler = new GamesHandler();
                gamesHandler.handle(jsonNode);
                System.out.println("JSON redirected successfully to GamesHandeler");
                break;
            case "games/statistics":
                GamesStatisticsHandler gamesStatisticsHandler = new GamesStatisticsHandler();
                gamesStatisticsHandler.handle(jsonNode);
                System.out.println("JSON redirected successfully to GamesStatisticsHandler");
                break;
            case "players/":
                PlayersHandler playersHandler = new PlayersHandler();
                playersHandler.handle(jsonNode);
                System.out.println("JSON redirected successfully to PlayersHandler");
                break;
            case "players/statistics":
                PlayersStatisticsHandler playersStatisticsHandler = new PlayersStatisticsHandler();
                playersStatisticsHandler.handle(jsonNode);
                System.out.println("JSON redirected successfully to PlayersStatisticsHandler");
                break;
            case "teams/":
                TeamsHandler teamsHandler = new TeamsHandler();
                teamsHandler.handle(jsonNode);
                System.out.println("JSON redirected successfully to TeamsHandler");
                break;
            case "teams/statistics":
                TeamsStatisticsHandler teamsStatisticsHandler = new TeamsStatisticsHandler();
                teamsStatisticsHandler.handle(jsonNode);
                System.out.println("JSON redirected successfully to TeamsStatisticsHandler");
                break;
            case "standings/":
                StandingsHandler standingsHandler = new StandingsHandler();
                standingsHandler.handle(jsonNode);
                System.out.println("JSON redirected successfully to StandingsHandler");
                break;
            default:
                System.out.println("JSON NOT redirected to any Handeler!!! ENDPOINT: "+endpoint);
                break;
        }
    }
}
