package com.IGallinari.LastGame.service.API_to_DB.HandleJSON;

import com.IGallinari.LastGame.entity.StatsTeam;
import com.IGallinari.LastGame.repository.StatsTeamRepository;
import com.IGallinari.LastGame.repository.TeamRepository;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StandingsHandler implements Handler{

    private TeamRepository teamRepository;

    private StatsTeamRepository statsTeamRepository;

    @Override
    public void handle(JsonNode jsonNode) {
        JsonNode standingsNode = jsonNode.get("response").get(0);

        for (JsonNode standingNode : standingsNode) {
            StatsTeam statsTeam = new StatsTeam();
            statsTeam.setSeason(standingNode.get("season").asInt());
            statsTeam.setTeam(teamRepository.findById(standingNode.get("team").get("id").asInt()));
            statsTeam.setRankConference(asInteger(standingNode.get("conference").get("rankConference")));
            statsTeam.setWinConference(asInteger(standingNode.get("conference").get("winConference")));
            statsTeam.setLossConference(asInteger(standingNode.get("conference").get("lossDivision")));
            statsTeam.setRankDivision(asInteger(standingNode.get("division").get("rankDivision")));
            statsTeam.setWinDivision(asInteger(standingNode.get("division").get("winDivision")));
            statsTeam.setLossDivision(asInteger(standingNode.get("division").get("lossDivision")));
            statsTeam.setWinHome(asInteger(standingNode.get("win").get("home")));
            statsTeam.setWinAway(asInteger(standingNode.get("win").get("away")));
            statsTeam.setWinPerc(asInteger(standingNode.get("win").get("percentage")));
            statsTeam.setLossHome(asInteger(standingNode.get("loss").get("home")));
            statsTeam.setLossAway(asInteger(standingNode.get("loss").get("away")));
            statsTeam.setLossPerc(asInteger(standingNode.get("loss").get("percentage")));
            statsTeam.setGamesBehind(asInteger(standingNode.get("gamesBehind")));
            statsTeam.setStreak(asInteger(standingNode.get("streak")));
            statsTeam.setWinStreak(standingNode.get("winStreak").asBoolean());
            statsTeamRepository.save(statsTeam);
            System.out.println("Object StatTeam statsTeam saved in the DB");
        }
    }
}
