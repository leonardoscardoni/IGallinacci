package com.IGallinari.LastGame.service.API_to_DB.populateDB;

import com.IGallinari.LastGame.entity.StatsGame;
import com.IGallinari.LastGame.repository.GameRepository;
import com.IGallinari.LastGame.repository.StatsGameRepository;
import com.IGallinari.LastGame.repository.TeamRepository;
import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalDate;

public class GamesStatisticsHandler {

    private GameRepository gameRepository;

    private TeamRepository teamRepository;

    private StatsGameRepository statsGameRepository;
    public void handle(JsonNode jsonNode) {
        JsonNode parametersNode = jsonNode.get("parameters").get(0);
        JsonNode gamesStatisticsNode = jsonNode.get("response").get(0);

        for (JsonNode gameStatisticsNode : gamesStatisticsNode) {
            StatsGame statsGame = new StatsGame();
            statsGame.setGame(gameRepository.findById(parametersNode.get("parameters").get("id").asInt()));
            statsGame.setTeam(teamRepository.findById(gameStatisticsNode.get("team").get("id").asInt()));
            statsGame.setFastBreakPoint(gameStatisticsNode.get("fastBreakPoints").asInt());
            statsGame.setPointsInPaint(gameStatisticsNode.get("pointsInPaint").asInt());
            statsGame.setBiggestLead(gameStatisticsNode.get("biggestLead").asInt());
            statsGame.setSecondChancePoints(gameStatisticsNode.get("secondChancePoints").asInt());
            statsGame.setPointsOffTurnovers(gameStatisticsNode.get("pointsOffTurnovers").asInt());
            statsGame.setLongestRun(gameStatisticsNode.get("longestRun").asInt());
            statsGame.setFgm(gameStatisticsNode.get("fgm").asInt());
            statsGame.setFga(gameStatisticsNode.get("fga").asInt());
            statsGame.setFgp(Float.parseFloat(gameStatisticsNode.get("fgp").asText()));
            statsGame.setFtm(gameStatisticsNode.get("ftm").asInt());
            statsGame.setFta(gameStatisticsNode.get("fta").asInt());
            statsGame.setFtp(Float.parseFloat(gameStatisticsNode.get("ftp").asText()));
            statsGame.setTpm(gameStatisticsNode.get("tpm").asInt());
            statsGame.setTpa(gameStatisticsNode.get("tpa").asInt());
            statsGame.setTpp(Float.parseFloat(gameStatisticsNode.get("tpp").asText()));
            statsGame.setOffReb(gameStatisticsNode.get("offReb").asInt());
            statsGame.setDefReb(gameStatisticsNode.get("defReb").asInt());
            statsGame.setTotReb(gameStatisticsNode.get("totReb").asInt());
            statsGame.setAssists(gameStatisticsNode.get("assists").asInt());
            statsGame.setPFouls(gameStatisticsNode.get("pFouls").asInt());
            statsGame.setSteals(gameStatisticsNode.get("steals").asInt());
            statsGame.setTurnovers(gameStatisticsNode.get("turnovers").asInt());
            statsGame.setBlocks(gameStatisticsNode.get("blocks").asInt());
            statsGame.setPlusMinus(gameStatisticsNode.get("plusMinus").asInt());
            statsGame.setMin(gameStatisticsNode.get("min").asText());
            statsGameRepository.save(statsGame);
        }
    }
}
