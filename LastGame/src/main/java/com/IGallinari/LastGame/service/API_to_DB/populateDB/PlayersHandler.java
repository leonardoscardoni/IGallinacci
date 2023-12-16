package com.IGallinari.LastGame.service.API_to_DB.populateDB;

import com.IGallinari.LastGame.entity.Player;
import com.IGallinari.LastGame.entity.Team;
import com.IGallinari.LastGame.repository.PlayerRepository;
import com.fasterxml.jackson.databind.JsonNode;

import java.sql.Time;
import java.time.LocalDate;

public class PlayersHandler {

    private PlayerRepository playerRepository;
    public void handle(JsonNode jsonNode) {
        JsonNode playersNode = jsonNode.get("response").get(0);

        for (JsonNode playerNode : playersNode) {
            Player player = new Player();
            player.setId(playerNode.get("id").asInt());
            player.setFirstname(playerNode.get("firstname").asText());
            player.setLastname(playerNode.get("lastname").asText());
            player.setDateOfBirth(LocalDate.parse(playerNode.get("birth").get("date").asText()));
            player.setCountry(playerNode.get("birth").get("country").asText());
            player.setStartYear(playerNode.get("nba").get("start").asInt());
            player.setPro(playerNode.get("nba").get("pro").asInt());
            player.setHeigth(Float.parseFloat(playerNode.get("height").get("meters").asText()));
            player.setWeight(Float.parseFloat(playerNode.get("weight").get("kilograms").asText()));
            player.setCollege(playerNode.get("college").asText());
            player.setAffiliation(playerNode.get("affiliation").asText());
            player.setJersey(playerNode.get("leagues").get("standard").get("jersey").asInt());
            player.setActive(playerNode.get("leagues").get("standard").get("active").asBoolean());
            player.setPos(playerNode.get("leagues").get("standard").get("pos").asText());
            playerRepository.save(player);
        }
    }
}
