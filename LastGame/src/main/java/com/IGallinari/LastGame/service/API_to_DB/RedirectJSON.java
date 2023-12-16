package com.IGallinari.LastGame.service.API_to_DB;

import com.IGallinari.LastGame.service.API_to_DB.HandleJSON.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
public class RedirectJSON {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final JsonNode jsonNode;

    public RedirectJSON(String jsonString) throws Exception {
        this.jsonNode = objectMapper.readTree(jsonString);
    }

    private void manageJSON() {
        String endpoint = jsonNode.get("get").asText();

        switch (endpoint) {
            case "games/":
                GamesHandler gamesHandler = new GamesHandler();
                gamesHandler.handle(jsonNode);
                break;
            case "games/statistics":
                GamesStatisticsHandler gamesStatisticsHandler = new GamesStatisticsHandler();
                gamesStatisticsHandler.handle(jsonNode);
                break;
            case "players/":
                PlayersHandler playersHandler = new PlayersHandler();
                playersHandler.handle(jsonNode);
                break;
            case "players/statistics":
                PlayersStatisticsHandler playersStatisticsHandler = new PlayersStatisticsHandler();
                playersStatisticsHandler.handle(jsonNode);
                break;
            case "teams/":
                TeamsHandler teamsHandler = new TeamsHandler();
                teamsHandler.handle(jsonNode);
                break;
            case "teams/statistics":
                TeamsStatisticsHandler teamsStatisticsHandler = new TeamsStatisticsHandler();
                teamsStatisticsHandler.handle(jsonNode);
                break;
            case "standings/":
                StandingsHandler standingsHandler = new StandingsHandler();
                standingsHandler.handle(jsonNode);
                break;
            default:
                throw new IllegalArgumentException("Endpoint non supportato: " + endpoint);
        }
    }
}
