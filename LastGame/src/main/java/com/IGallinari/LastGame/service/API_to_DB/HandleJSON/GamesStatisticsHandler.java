package com.IGallinari.LastGame.service.API_to_DB.HandleJSON;

import com.IGallinari.LastGame.entity.IdStatsGame;
import com.IGallinari.LastGame.entity.StatsGame;
import com.IGallinari.LastGame.repository.GameRepository;
import com.IGallinari.LastGame.repository.StatsGameRepository;
import com.IGallinari.LastGame.repository.TeamRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class GamesStatisticsHandler implements Handler{

    private GameRepository gameRepository;

    private TeamRepository teamRepository;

    private StatsGameRepository statsGameRepository;

    @Override
    public void handle(JsonNode jsonNode) {
        JsonNode parametersNode = jsonNode.get("parameters");
        ArrayNode gamesStatisticsNode = (ArrayNode) jsonNode.get("response");

        for (JsonNode gameStatisticsNode : gamesStatisticsNode) {
            StatsGame statsGame = new StatsGame();
            IdStatsGame idStatsGame = new IdStatsGame();
            idStatsGame.setGameId(parametersNode.get("parameters").get("id").asInt());
            idStatsGame.setTeamId(gameStatisticsNode.get("team").get("id").asInt());
            statsGame.setStatsGameId(idStatsGame);
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
            System.out.println("Object StatsGame statsGame saved in the DB");
        }
    }
}
