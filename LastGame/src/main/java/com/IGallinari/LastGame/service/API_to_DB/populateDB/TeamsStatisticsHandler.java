package com.IGallinari.LastGame.service.API_to_DB.populateDB;

import com.IGallinari.LastGame.entity.StatsTeam;
import com.IGallinari.LastGame.repository.StatsTeamRepository;
import com.IGallinari.LastGame.repository.TeamRepository;
import com.fasterxml.jackson.databind.JsonNode;

public class TeamsStatisticsHandler {

    private TeamRepository teamRepository;

    private StatsTeamRepository statsTeamRepository;

    public void handle(JsonNode jsonNode) {
        JsonNode parametersNode = jsonNode.get("parameters").get(0);
        JsonNode teamStatisticsNode = jsonNode.get("response").get(0);
        
        StatsTeam statsTeam = new StatsTeam();
        statsTeam.setSeason(parametersNode.get("season").asInt());
        statsTeam.setTeam(teamRepository.findById(parametersNode.get("id").asInt()));
        statsTeam.setGame(teamStatisticsNode.get("games").asInt());
        statsTeam.setFastBreakPoints(teamStatisticsNode.get("fastBreakPoints").asInt());
        statsTeam.setPointsInPaint(teamStatisticsNode.get("pointsInPaint").asInt());
        statsTeam.setBiggestLead(teamStatisticsNode.get("biggestLead").asInt());
        statsTeam.setSecondChancePoints(teamStatisticsNode.get("secondChancePoints").asInt());
        statsTeam.setPointsOffTurnovers(teamStatisticsNode.get("pointsOffTurnovers").asInt());
        statsTeam.setLongestRun(teamStatisticsNode.get("longestRun").asInt());
        statsTeam.setPoints(teamStatisticsNode.get("points").asInt());
        statsTeam.setFgm(teamStatisticsNode.get("fgm").asInt());
        statsTeam.setFga(teamStatisticsNode.get("fga").asInt());
        statsTeam.setFgp(Float.parseFloat(teamStatisticsNode.get("fgp").asText()));
        statsTeam.setFtm(teamStatisticsNode.get("ftm").asInt());
        statsTeam.setFta(teamStatisticsNode.get("fta").asInt());
        statsTeam.setFtp(Float.parseFloat(teamStatisticsNode.get("ftp").asText()));
        statsTeam.setTpm(teamStatisticsNode.get("tpm").asInt());
        statsTeam.setTpa(teamStatisticsNode.get("tpa").asInt());
        statsTeam.setTpp(Float.parseFloat(teamStatisticsNode.get("tpp").asText()));
        statsTeam.setOffReb(teamStatisticsNode.get("offReb").asInt());
        statsTeam.setDefReb(teamStatisticsNode.get("defReb").asInt());
        statsTeam.setTotReb(teamStatisticsNode.get("totReb").asInt());
        statsTeam.setAssists(teamStatisticsNode.get("assists").asInt());
        statsTeam.setPFouls(teamStatisticsNode.get("pFouls").asInt());
        statsTeam.setSteals(teamStatisticsNode.get("steals").asInt());
        statsTeam.setTurnovers(teamStatisticsNode.get("turnovers").asInt());
        statsTeam.setBlocks(teamStatisticsNode.get("blocks").asInt());
        statsTeam.setPlusMinus(teamStatisticsNode.get("plusMinus").asInt());
        statsTeamRepository.save(statsTeam);
    }
}
