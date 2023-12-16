package com.IGallinari.LastGame.service.API_to_DB.populateDB;

import com.IGallinari.LastGame.entity.Team;
import com.IGallinari.LastGame.repository.TeamRepository;
import com.fasterxml.jackson.databind.JsonNode;

public class TeamsHandler {

    private TeamRepository teamRepository;
    public void handle(JsonNode jsonNode) {
        JsonNode teamsNode = jsonNode.get("response").get(0);

        for (JsonNode teamNode : teamsNode) {
            Team team = new Team();
            team.setId(teamNode.get("id").asInt());
            team.setName(teamNode.get("name").asText());
            team.setNickname(teamNode.get("nickname").asText());
            team.setCode(teamNode.get("code").asText());
            team.setCity(teamNode.get("city").asText());
            team.setLogo(teamNode.get("logo").asText());
            team.setAllstar(teamNode.get("allStar").asBoolean());
            team.setConference(teamNode.get("leagues").get("standard").get("conference").asText());
            team.setDivision(teamNode.get("leagues").get("standard").get("division").asText());
            teamRepository.save(team);
        }
    }
}
