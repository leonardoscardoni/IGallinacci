package com.IGallinari.LastGame.service.API_to_DB.HandleJSON;

import com.IGallinari.LastGame.entity.Team;
import com.IGallinari.LastGame.repository.TeamRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
/**
 * Service class to handle the processing of team data received in JSON format.
 * This class is responsible for parsing the JSON data, extracting relevant team information,
 * and persisting it into the database using TeamRepository.
 */
@Service
@AllArgsConstructor
public class TeamsHandler implements Handler{

    private TeamRepository teamRepository;
    /**
     * Processes the JSON node containing team data.
     * It parses and converts JSON data into Team entity objects and saves them to the database.
     *
     * @param jsonNode The JSON node containing the team data.
     */
    @Override
    public void handle(JsonNode jsonNode) {
        ArrayNode teamsNode = (ArrayNode) jsonNode.get("response");
        for (JsonNode teamNode : teamsNode) {
                Team team = new Team();
                team.setId(asInteger(teamNode.get("id")));
                team.setName(asString(teamNode.get("name")));
                team.setNickname(asString(teamNode.get("nickname")));
                team.setCode(asString(teamNode.get("code")));
                team.setCity(asString(teamNode.get("city")));
                team.setLogo(asString(teamNode.get("logo")));
                team.setAllstar(teamNode.get("allStar").asBoolean());
                team.setConference(asString(teamNode.get("leagues").get("standard").get("conference")));
                team.setDivision(asString(teamNode.get("leagues").get("standard").get("division")));
                teamRepository.save(team);
                System.out.println("Object Team team saved in the DB");
        }
    }
}

