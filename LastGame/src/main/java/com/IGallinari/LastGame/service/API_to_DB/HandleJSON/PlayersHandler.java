package com.IGallinari.LastGame.service.API_to_DB.HandleJSON;

import com.IGallinari.LastGame.entity.id_class.IdPlayerTeam;
import com.IGallinari.LastGame.entity.Player;
import com.IGallinari.LastGame.entity.PlayerTeam;
import com.IGallinari.LastGame.repository.PlayerRepository;
import com.IGallinari.LastGame.repository.PlayerTeamRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
/**
 * Service class to handle the processing of player data received in JSON format.
 * This class is responsible for parsing the JSON data, extracting relevant player information,
 * and persisting it into the database using PlayerRepository and PlayerTeamRepository.
 */
@Service
@AllArgsConstructor
public class PlayersHandler implements Handler{

    private PlayerRepository playerRepository;

    private PlayerTeamRepository playerTeamRepository;

    /**
     * Processes the JSON node containing player data.
     * It parses and converts JSON data into Player and PlayerTeam entity objects
     * and saves them to the database.
     *
     * @param jsonNode The JSON node containing the player data.
     */

    @Override
    public void handle(JsonNode jsonNode) {
        JsonNode paramsNode = jsonNode.get("parameters");
        ArrayNode playersNode = (ArrayNode) jsonNode.get("response");

        for (JsonNode playerNode : playersNode) {
            Player player = new Player();
            player.setId(playerNode.get("id").asInt());
            player.setFirstname(asString(playerNode.get("firstname")));
            player.setLastname(asString(playerNode.get("lastname")));
            System.out.println("Saving player, id: "+player.getId()+", name: "+player.getFirstname()+", lastname: "+player.getLastname());
            player.setDateOfBirth(asLocalDate(playerNode.get("birth").get("date")));
            player.setCountry(asString(playerNode.get("birth").get("country")));
            player.setStartYear(asInteger(playerNode.get("nba").get("start")));
            player.setPro(asInteger(playerNode.get("nba").get("pro")));
            player.setHeight(asFloat(playerNode.get("height").get("meters")));
            player.setWeight(asFloat(playerNode.get("weight").get("kilograms")));
            player.setCollege(asString(playerNode.get("college")));
            player.setAffiliation(asString(playerNode.get("affiliation")));
            player.setJersey(asInteger(playerNode.get("leagues").get("standard").get("jersey")));
            player.setActive(playerNode.get("leagues").get("standard").get("active").asBoolean());
            player.setPos(asString(playerNode.get("leagues").get("standard").get("pos")));
            playerRepository.save(player);
            PlayerTeam playerTeam = new PlayerTeam();
            IdPlayerTeam idPlayerTeam = new IdPlayerTeam();
            idPlayerTeam.setPlayerId(playerNode.get("id").asInt());
            idPlayerTeam.setTeamId(paramsNode.get("team").asInt());
            idPlayerTeam.setSeason(paramsNode.get("season").asInt());
            playerTeam.setIdPlayerTeam(idPlayerTeam);
            playerTeamRepository.save(playerTeam);
            System.out.println("Object Player player saved in the DB");
        }
    }
}
