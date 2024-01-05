package com.IGallinari.LastGame.service.API_to_DB.HandleJSON;

import com.IGallinari.LastGame.entity.IdStatsTeam;
import com.IGallinari.LastGame.entity.StatsTeam;
import com.IGallinari.LastGame.entity.Team;
import com.IGallinari.LastGame.repository.StatsTeamRepository;
import com.IGallinari.LastGame.repository.TeamRepository;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class TeamsStatisticsHandler implements Handler{

    private TeamRepository teamRepository;

    private StatsTeamRepository statsTeamRepository;

    @Override
    public void handle(JsonNode jsonNode) {
        JsonNode parametersNode = jsonNode.get("parameters");
<<<<<<< Updated upstream
        JsonNode teamStatisticsNode = jsonNode.get("response");
        
        StatsTeam statsTeam = new StatsTeam();
        IdStatsTeam idStatsTeam = new IdStatsTeam();
        idStatsTeam.setTeamId(parametersNode.get("id").asInt());
        idStatsTeam.setSeason(parametersNode.get("season").asInt());
        statsTeam.setStatsTeamId(idStatsTeam);
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
        System.out.println("Object StatTeam statsTeam saved in the DB");
=======
        JsonNode teamsStatisticsNode = (ArrayNode) jsonNode.get("response");
        Team team = teamRepository.findById(parametersNode.get("id").asInt());
        int season = parametersNode.get("season").asInt();
        StatsTeam statsTeam= statsTeamRepository.findByTeamAndSeason(team,season);
        if(statsTeam == null) {
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
>>>>>>> Stashed changes
    }
}
