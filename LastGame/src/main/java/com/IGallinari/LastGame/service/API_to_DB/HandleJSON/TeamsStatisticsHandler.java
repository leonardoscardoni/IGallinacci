package com.IGallinari.LastGame.service.API_to_DB.HandleJSON;

import com.IGallinari.LastGame.entity.Team;
import com.IGallinari.LastGame.entity.StatsTeam;
import com.IGallinari.LastGame.entity.id_class.IdStatsTeam;
import com.IGallinari.LastGame.repository.StatsTeamRepository;
import com.IGallinari.LastGame.repository.TeamRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
/**
 * Service class to handle the processing of team statistics data received in JSON format.
 * This class is responsible for parsing the JSON data, extracting relevant team statistics information,
 * and persisting or updating it into the database using StatsTeamRepository and TeamRepository.
 */
@Service
@AllArgsConstructor
public class TeamsStatisticsHandler implements Handler{

    private StatsTeamRepository statsTeamRepository;

    private TeamRepository teamRepository;
    /**
     * Processes the JSON node containing team statistics data.
     * It parses and converts JSON data into StatsTeam entity objects and saves or updates them to the database.
     *
     * @param jsonNode The JSON node containing the team statistics data.
     */
    @Override
    public void handle(JsonNode jsonNode) {
        JsonNode parametersNode = jsonNode.get("parameters");
        ArrayNode teamsStatisticsNode = (ArrayNode) jsonNode.get("response");
        Team team = teamRepository.findById(parametersNode.get("id").asInt());
        int season = parametersNode.get("season").asInt();
        StatsTeam statsTeam = statsTeamRepository.findByTeamAndSeason(team, season);
        if(statsTeam==null){
            statsTeam = new StatsTeam();
            IdStatsTeam idStatsTeam = new IdStatsTeam();
            idStatsTeam.setTeamId(asInteger(parametersNode.get("id")));
            idStatsTeam.setSeason(asInteger(parametersNode.get("season")));
            statsTeam.setStatsTeamId(idStatsTeam);
        }
        for(JsonNode teamStatisticsNode: teamsStatisticsNode) {
            statsTeam.setGames(asInteger(teamStatisticsNode.get("games")));
            statsTeam.setFastBreakPoints(asInteger(teamStatisticsNode.get("fastBreakPoints")));
            statsTeam.setPointsInPaint(asInteger(teamStatisticsNode.get("pointsInPaint")));
            statsTeam.setBiggestLead(asInteger(teamStatisticsNode.get("biggestLead")));
            statsTeam.setSecondChancePoints(asInteger(teamStatisticsNode.get("secondChancePoints")));
            statsTeam.setPointsOffTurnovers(asInteger(teamStatisticsNode.get("pointsOffTurnovers")));
            statsTeam.setLongestRun(asInteger(teamStatisticsNode.get("longestRun")));
            statsTeam.setPoints(asInteger(teamStatisticsNode.get("points")));
            statsTeam.setFgm(asInteger(teamStatisticsNode.get("fgm")));
            statsTeam.setFga(asInteger(teamStatisticsNode.get("fga")));
            statsTeam.setFgp(asFloat(teamStatisticsNode.get("fgp")));
            statsTeam.setFtm(asInteger(teamStatisticsNode.get("ftm")));
            statsTeam.setFta(asInteger(teamStatisticsNode.get("fta")));
            statsTeam.setFtp(asFloat(teamStatisticsNode.get("ftp")));
            statsTeam.setTpm(asInteger(teamStatisticsNode.get("tpm")));
            statsTeam.setTpa(asInteger(teamStatisticsNode.get("tpa")));
            statsTeam.setTpp(asFloat(teamStatisticsNode.get("tpp")));
            statsTeam.setOffReb(asInteger(teamStatisticsNode.get("offReb")));
            statsTeam.setDefReb(asInteger(teamStatisticsNode.get("defReb")));
            statsTeam.setTotReb(asInteger(teamStatisticsNode.get("totReb")));
            statsTeam.setAssists(asInteger(teamStatisticsNode.get("assists")));
            statsTeam.setPFouls(asInteger(teamStatisticsNode.get("pFouls")));
            statsTeam.setSteals(asInteger(teamStatisticsNode.get("steals")));
            statsTeam.setTurnovers(asInteger(teamStatisticsNode.get("turnovers")));
            statsTeam.setBlocks(asInteger(teamStatisticsNode.get("blocks")));
            statsTeam.setPlusMinus(asInteger(teamStatisticsNode.get("plusMinus")));
            statsTeamRepository.save(statsTeam);
        }
        System.out.println("Object StatTeam saved in the DB");
    }
}
