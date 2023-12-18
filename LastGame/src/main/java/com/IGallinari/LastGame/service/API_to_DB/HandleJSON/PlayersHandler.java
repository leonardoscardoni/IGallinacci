package com.IGallinari.LastGame.service.API_to_DB.HandleJSON;

import com.IGallinari.LastGame.entity.Player;
import com.IGallinari.LastGame.repository.PlayerRepository;
import com.IGallinari.LastGame.repository.TeamRepository;
import com.fasterxml.jackson.databind.JsonNode;
import java.time.LocalDate;

public class PlayersHandler implements Handler{

    private PlayerRepository playerRepository;

    private TeamRepository teamRepository;

    @Override
    public void handle(JsonNode jsonNode) {
        JsonNode paramsNode = jsonNode.get("parameters").get(0);
        JsonNode playersNode = jsonNode.get("response").get(0);

        for (JsonNode playerNode : playersNode) {
            Player player = new Player();
            player.setId(playerNode.get("id").asInt());
            player.setTeam(teamRepository.findById(paramsNode.get("team").asInt()));
            player.setFirstname(playerNode.get("firstname").asText(null));
            player.setLastname(playerNode.get("lastname").asText(null));
            player.setDateOfBirth(LocalDate.parse(playerNode.get("birth").get("date").asText(null)));
            player.setCountry(playerNode.get("birth").get("country").asText());
            player.setStartYear(asInteger(playerNode.get("nba").get("start")));
            player.setPro(asInteger(playerNode.get("nba").get("pro")));
            player.setHeigth(asFloat(playerNode.get("height").get("meters")));
            player.setWeight(asFloat(playerNode.get("weight").get("kilograms")));
            player.setCollege(playerNode.get("college").asText());
            player.setAffiliation(playerNode.get("affiliation").asText());
            player.setJersey(asInteger(playerNode.get("leagues").get("standard").get("jersey")));
            player.setActive(playerNode.get("leagues").get("standard").get("active").asBoolean());
            player.setPos(playerNode.get("leagues").get("standard").get("pos").asText(null));
            playerRepository.save(player);
        }
    }
}
