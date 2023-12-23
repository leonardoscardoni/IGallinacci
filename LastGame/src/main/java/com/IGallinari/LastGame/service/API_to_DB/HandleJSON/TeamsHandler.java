package com.IGallinari.LastGame.service.API_to_DB.HandleJSON;

import com.IGallinari.LastGame.entity.Team;
import com.IGallinari.LastGame.repository.TeamRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

@Service
@AllArgsConstructor
public class TeamsHandler implements Handler{

    private TeamRepository teamRepository;

    @Override
    public void handle(JsonNode jsonNode) {
        ObjectNode teamsNode = (ObjectNode) jsonNode.get("response").get(0);
        Iterator<Map.Entry<String, JsonNode>> teamsIterator = teamsNode.fields();
        while (teamsIterator.hasNext()) {
            Map.Entry<String, JsonNode> entry = teamsIterator.next();
            JsonNode teamNode = entry.getValue();
                Team team = new Team();
                team.setId(asInteger(teamNode.get("id")));
                team.setName(teamNode.get("name").asText(null));
                team.setNickname(teamNode.get("nickname").asText(null));
                team.setCode(teamNode.get("code").asText(null));
                team.setCity(teamNode.get("city").asText(null));
                team.setLogo(teamNode.get("logo").asText(null));
                team.setAllstar(teamNode.get("allStar").asBoolean());
                team.setConference(teamNode.get("leagues").get("standard").get("conference").asText(null));
                team.setDivision(teamNode.get("leagues").get("standard").get("division").asText(null));
                teamRepository.save(team);
                System.out.println("Object Team team saved in the DB");
            }
        }
}

