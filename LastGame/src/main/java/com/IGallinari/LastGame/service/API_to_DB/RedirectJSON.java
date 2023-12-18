package com.IGallinari.LastGame.service.API_to_DB;

import com.IGallinari.LastGame.service.API_to_DB.HandleJSON.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
public class RedirectJSON {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public boolean manageJSON(String jsonString) throws JsonProcessingException {
        JsonNode jsonNode = objectMapper.readTree(jsonString);
        String endpoint = jsonNode.get("get").asText();

        switch (endpoint) {
            case "games/":
                GamesHandler gamesHandler = new GamesHandler();
                gamesHandler.handle(jsonNode);
                return true;
            case "games/statistics":
                GamesStatisticsHandler gamesStatisticsHandler = new GamesStatisticsHandler();
                gamesStatisticsHandler.handle(jsonNode);
                return true;
            case "players/":
                PlayersHandler playersHandler = new PlayersHandler();
                playersHandler.handle(jsonNode);
                return true;
            case "players/statistics":
                PlayersStatisticsHandler playersStatisticsHandler = new PlayersStatisticsHandler();
                playersStatisticsHandler.handle(jsonNode);
                return true;
            case "teams/":
                TeamsHandler teamsHandler = new TeamsHandler();
                teamsHandler.handle(jsonNode);
                return true;
            case "teams/statistics":
                TeamsStatisticsHandler teamsStatisticsHandler = new TeamsStatisticsHandler();
                teamsStatisticsHandler.handle(jsonNode);
                return true;
            case "standings/":
                StandingsHandler standingsHandler = new StandingsHandler();
                standingsHandler.handle(jsonNode);
                return true;
            default:
                return false;
        }
    }
}
