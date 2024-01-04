package com.IGallinari.LastGame.service.API_to_DB.HandleJSON;

import com.IGallinari.LastGame.entity.Game;
import com.IGallinari.LastGame.entity.IdStatsGame;
import com.IGallinari.LastGame.entity.StatsGame;
import com.IGallinari.LastGame.entity.Team;
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
            System.out.println("id game: "+asInteger(parametersNode.get("id")));
            System.out.println("id team: "+gameStatisticsNode.get("team").get("id").asInt());
            Team team = teamRepository.findById(gameStatisticsNode.get("team").get("id").asInt());
            Game game = gameRepository.findById(parametersNode.get("id").asInt());
            StatsGame statsGame = statsGameRepository.findStatsGameByGameAndTeam(game,team);
            ArrayNode teamStatisticsNode = (ArrayNode) gameStatisticsNode.get("statistics");
            for(JsonNode statisticNode : teamStatisticsNode) {
                statsGame.setFastBreakPoint(asInteger(statisticNode.get("fastBreakPoints")));
                statsGame.setPointsInPaint(asInteger(statisticNode.get("pointsInPaint")));
                statsGame.setBiggestLead(asInteger(statisticNode.get("biggestLead")));
                statsGame.setSecondChancePoints(asInteger(statisticNode.get("secondChancePoints")));
                statsGame.setPointsOffTurnovers(asInteger(statisticNode.get("pointsOffTurnovers")));
                statsGame.setLongestRun(asInteger(statisticNode.get("longestRun")));
                statsGame.setFgm(asInteger(statisticNode.get("fgm")));
                statsGame.setFga(asInteger(statisticNode.get("fga")));
                statsGame.setFgp(asFloat(statisticNode.get("fgp")));
                statsGame.setFtm(asInteger(statisticNode.get("ftm")));
                statsGame.setFta(asInteger(statisticNode.get("fta")));
                statsGame.setFtp(asFloat(statisticNode.get("ftp")));
                statsGame.setTpm(asInteger(statisticNode.get("tpm")));
                statsGame.setTpa(asInteger(statisticNode.get("tpa")));
                statsGame.setTpp(asFloat(statisticNode.get("tpp")));
                statsGame.setOffReb(asInteger(statisticNode.get("offReb")));
                statsGame.setDefReb(asInteger(statisticNode.get("defReb")));
                statsGame.setTotReb(asInteger(statisticNode.get("totReb")));
                statsGame.setAssists(asInteger(statisticNode.get("assists")));
                statsGame.setPFouls(asInteger(statisticNode.get("pFouls")));
                statsGame.setSteals(asInteger(statisticNode.get("steals")));
                statsGame.setTurnovers(asInteger(statisticNode.get("turnovers")));
                statsGame.setBlocks(asInteger(statisticNode.get("blocks")));
                statsGame.setPlusMinus(asInteger(statisticNode.get("plusMinus")));
                statsGame.setMin(asString(statisticNode.get("min")));
            }
            statsGameRepository.save(statsGame);
            System.out.println("Object StatsGame updated in the DB");
        }
    }
}
