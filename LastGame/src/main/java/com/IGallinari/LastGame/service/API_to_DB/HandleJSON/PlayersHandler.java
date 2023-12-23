package com.IGallinari.LastGame.service.API_to_DB.HandleJSON;

import com.IGallinari.LastGame.entity.Player;
import com.IGallinari.LastGame.repository.PlayerRepository;
import com.IGallinari.LastGame.repository.TeamRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class PlayersHandler implements Handler{

    private PlayerRepository playerRepository;

    private TeamRepository teamRepository;

    @Override
    @Transactional
    public void handle(JsonNode jsonNode) {
        JsonNode paramsNode = jsonNode.get("parameters");
        ArrayNode playersNode = (ArrayNode) jsonNode.get("response");

        for (JsonNode playerNode : playersNode) {
            Player player = new Player();
            player.setId(playerNode.get("id").asInt());
            player.setTeam(teamRepository.findById(paramsNode.get("team").asInt()));
            player.setFirstname(playerNode.get("firstname").asText(null));
            player.setLastname(playerNode.get("lastname").asText(null));
            player.setDateOfBirth(LocalDate.parse(playerNode.get("birth").get("date").asText(null)));
            player.setCountry(playerNode.get("birth").get("country").asText(null));
            player.setStartYear(asInteger(playerNode.get("nba").get("start")));
            player.setPro(asInteger(playerNode.get("nba").get("pro")));
            player.setHeight(asFloat(playerNode.get("height").get("meters")));
            player.setWeight(asFloat(playerNode.get("weight").get("kilograms")));
            player.setCollege(playerNode.get("college").asText(null));
            player.setAffiliation(playerNode.get("affiliation").asText(null));
            player.setJersey(asInteger(playerNode.get("leagues").get("standard").get("jersey")));
            player.setActive(playerNode.get("leagues").get("standard").get("active").asBoolean());
            player.setPos(playerNode.get("leagues").get("standard").get("pos").asText(null));
            playerRepository.save(player);
            System.out.println("Object Player player saved in the DB");
        }
    }
}
