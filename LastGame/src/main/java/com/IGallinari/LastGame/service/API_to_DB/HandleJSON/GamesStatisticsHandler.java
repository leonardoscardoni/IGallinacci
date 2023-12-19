package com.IGallinari.LastGame.service.API_to_DB.HandleJSON;

import com.IGallinari.LastGame.entity.StatsGame;
import com.IGallinari.LastGame.repository.GameRepository;
import com.IGallinari.LastGame.repository.StatsGameRepository;
import com.IGallinari.LastGame.repository.TeamRepository;
import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalDate;

public class GamesStatisticsHandler implements Handler{

    private GameRepository gameRepository;

    private TeamRepository teamRepository;

    private StatsGameRepository statsGameRepository;

    @Override
    public void handle(JsonNode jsonNode) {
        JsonNode parametersNode = jsonNode.get("parameters").get(0);
        JsonNode gamesStatisticsNode = jsonNode.get("response").get(0);

        for (JsonNode gameStatisticsNode : gamesStatisticsNode) {
            StatsGame statsGame = new StatsGame();
            statsGame.setGame(gameRepository.findById(parametersNode.get("parameters").get("id").asInt()));
            statsGame.setTeam(teamRepository.findById(gameStatisticsNode.get("team").get("id").asInt()));
            statsGame.setFastBreakPoint(asInteger(gameStatisticsNode.get("fastBreakPoints")));
            statsGame.setPointsInPaint(asInteger(gameStatisticsNode.get("pointsInPaint")));
            statsGame.setBiggestLead(asInteger(gameStatisticsNode.get("biggestLead")));
            statsGame.setSecondChancePoints(asInteger(gameStatisticsNode.get("secondChancePoints")));
            statsGame.setPointsOffTurnovers(asInteger(gameStatisticsNode.get("pointsOffTurnovers")));
            statsGame.setLongestRun(asInteger(gameStatisticsNode.get("longestRun")));
            statsGame.setFgm(asInteger(gameStatisticsNode.get("fgm")));
            statsGame.setFga(asInteger(gameStatisticsNode.get("fga")));
            statsGame.setFgp(asFloat(gameStatisticsNode.get("fgp")));
            statsGame.setFtm(asInteger(gameStatisticsNode.get("ftm")));
            statsGame.setFta(asInteger(gameStatisticsNode.get("fta")));
            statsGame.setFtp(asFloat(gameStatisticsNode.get("ftp")));
            statsGame.setTpm(asInteger(gameStatisticsNode.get("tpm")));
            statsGame.setTpa(asInteger(gameStatisticsNode.get("tpa")));
            statsGame.setTpp(asFloat(gameStatisticsNode.get("tpp")));
            statsGame.setOffReb(asInteger(gameStatisticsNode.get("offReb")));
            statsGame.setDefReb(asInteger(gameStatisticsNode.get("defReb")));
            statsGame.setTotReb(asInteger(gameStatisticsNode.get("totReb")));
            statsGame.setAssists(asInteger(gameStatisticsNode.get("assists")));
            statsGame.setPFouls(asInteger(gameStatisticsNode.get("pFouls")));
            statsGame.setSteals(asInteger(gameStatisticsNode.get("steals")));
            statsGame.setTurnovers(asInteger(gameStatisticsNode.get("turnovers")));
            statsGame.setBlocks(asInteger(gameStatisticsNode.get("blocks")));
            statsGame.setPlusMinus(asInteger(gameStatisticsNode.get("plusMinus")));
            statsGame.setMin(gameStatisticsNode.get("min").asText(null));
            statsGameRepository.save(statsGame);
        }
    }
}
