package com.IGallinari.LastGame.service.API_to_DB.populateDB;

import com.IGallinari.LastGame.entity.Player;
import com.IGallinari.LastGame.entity.Standing;
import com.IGallinari.LastGame.repository.StandingRepository;
import com.IGallinari.LastGame.repository.TeamRepository;
import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalDate;

public class StandingsHandler {

    private TeamRepository teamRepository;

    private StandingRepository standingRepository;
    public void handle(JsonNode jsonNode) {
        JsonNode standingsNode = jsonNode.get("response").get(0);

        for (JsonNode standingNode : standingsNode) {
            Standing standing = new Standing();
            standing.setSeason(standingNode.get("season").asInt());
            standing.setTeam(teamRepository.findById(standingNode.get("team").get("id").asInt()));
            standing.setRankConference(standingNode.get("conference").get("rankConference").asInt());
            standing.setWinConference(standingNode.get("conference").get("winConference").asInt());
            standing.setLossConference(standingNode.get("conference").get("lossDivision").asInt());
            standing.setRankDivision(standingNode.get("division").get("rankDivision").asInt());
            standing.setWinDivision(standingNode.get("division").get("winDivision").asInt());
            standing.setLossDivision(standingNode.get("division").get("lossDivision").asInt());
            standing.setWinHome(standingNode.get("win").get("home").asInt());
            standing.setWinAway(standingNode.get("win").get("away").asInt());
            standing.setWinPerc(standingNode.get("win").get("percentage").asInt());
            standing.setLossHome(standingNode.get("loss").get("home").asInt());
            standing.setLossAway(standingNode.get("loss").get("away").asInt());
            standing.setLossPerc(standingNode.get("loss").get("percentage").asInt());
            standing.setGamesBehind(standingNode.get("gamesBehind").asInt());
            standing.setStreak(standingNode.get("streak").asInt());
            standing.setWinStreak(standingNode.get("winStreak").asBoolean());
            standingRepository.save(standing);
        }
    }
}
