package com.IGallinari.LastGame.service.API_to_DB.HandleJSON;

import com.IGallinari.LastGame.entity.StatsTeam;
import com.IGallinari.LastGame.entity.Team;
import com.IGallinari.LastGame.repository.StatsTeamRepository;
import com.IGallinari.LastGame.repository.TeamRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StandingsHandler implements Handler{

    private TeamRepository teamRepository;

    private StatsTeamRepository statsTeamRepository;

    @Override
    public void handle(JsonNode jsonNode) {
        ArrayNode standingsNode = (ArrayNode) jsonNode.get("response");

        for (JsonNode standingNode : standingsNode) {
            Team team = teamRepository.findById(standingNode.get("team").get("id").asInt());
            StatsTeam statsTeam = statsTeamRepository.findByTeamAndSeason(team,standingNode.get("season").asInt());
            statsTeam.setRankConference(asInteger(standingNode.get("conference").get("rank")));
            statsTeam.setWinConference(asInteger(standingNode.get("conference").get("win")));
            statsTeam.setLossConference(asInteger(standingNode.get("conference").get("loss")));
            statsTeam.setRankDivision(asInteger(standingNode.get("division").get("rank")));
            statsTeam.setWinDivision(asInteger(standingNode.get("division").get("win")));
            statsTeam.setLossDivision(asInteger(standingNode.get("division").get("loss")));
            statsTeam.setWinHome(asInteger(standingNode.get("win").get("home")));
            statsTeam.setWinAway(asInteger(standingNode.get("win").get("away")));
            statsTeam.setWinPerc(asFloat(standingNode.get("win").get("percentage")));
            statsTeam.setLossHome(asInteger(standingNode.get("loss").get("home")));
            statsTeam.setLossAway(asInteger(standingNode.get("loss").get("away")));
            statsTeam.setLossPerc(asFloat(standingNode.get("loss").get("percentage")));
            statsTeam.setGamesBehind(asInteger(standingNode.get("gamesBehind")));
            statsTeam.setStreak(asInteger(standingNode.get("streak")));
            statsTeam.setWinStreak(standingNode.get("winStreak").asBoolean());
            statsTeamRepository.save(statsTeam);
            System.out.println("Object StatTeam statsTeam saved in the DB");
        }
    }
}
