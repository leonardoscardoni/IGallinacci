package com.IGallinari.LastGame.service.API_to_DB.HandleJSON;

import com.IGallinari.LastGame.entity.StatsPlayer;
import com.IGallinari.LastGame.repository.GameRepository;
import com.IGallinari.LastGame.repository.PlayerRepository;
import com.IGallinari.LastGame.repository.StatsPlayerRepository;
import com.IGallinari.LastGame.repository.TeamRepository;
import com.fasterxml.jackson.databind.JsonNode;

public class PlayersStatisticsHandler {
    private GameRepository gameRepository;

    private TeamRepository teamRepository;

    private PlayerRepository playerRepository;

    private StatsPlayerRepository statsPlayerRepository;

    public void handle(JsonNode jsonNode) {
        JsonNode playersStatisticsNode = jsonNode.get("response").get(0);

        for (JsonNode playerStatisticsNode : playersStatisticsNode) {
            StatsPlayer statsPlayer = new StatsPlayer();
            statsPlayer.setGame(gameRepository.findById(playerStatisticsNode.get("game").get("id").asInt()));
            statsPlayer.setTeam(teamRepository.findById(playerStatisticsNode.get("team").get("id").asInt()));
            statsPlayer.setPlayer(playerRepository.findById(playerStatisticsNode.get("player").get("id").asInt()));
            statsPlayer.setPoints(playerStatisticsNode.get("points").asInt());
            statsPlayer.setPos(playerStatisticsNode.get("pos").asText());
            statsPlayer.setMin(Float.parseFloat(playerStatisticsNode.get("min").asText()));//
            statsPlayer.setFgm(playerStatisticsNode.get("fgm").asInt());
            statsPlayer.setFga(playerStatisticsNode.get("fga").asInt());
            statsPlayer.setFgp(Float.parseFloat(playerStatisticsNode.get("fgp").asText()));
            statsPlayer.setFtm(playerStatisticsNode.get("ftm").asInt());
            statsPlayer.setFta(playerStatisticsNode.get("fta").asInt());
            statsPlayer.setFtp(Float.parseFloat(playerStatisticsNode.get("ftp").asText()));
            statsPlayer.setTpm(playerStatisticsNode.get("tpm").asInt());
            statsPlayer.setTpa(playerStatisticsNode.get("tpa").asInt());
            statsPlayer.setTpp(Float.parseFloat(playerStatisticsNode.get("tpp").asText()));
            statsPlayer.setOffReb(playerStatisticsNode.get("offReb").asInt());
            statsPlayer.setDefReb(playerStatisticsNode.get("defReb").asInt());
            statsPlayer.setTotReb(playerStatisticsNode.get("totReb").asInt());
            statsPlayer.setAssists(playerStatisticsNode.get("assists").asInt());
            statsPlayer.setPFouls(playerStatisticsNode.get("pFouls").asInt());
            statsPlayer.setSteals(playerStatisticsNode.get("steals").asInt());
            statsPlayer.setTurnovers(playerStatisticsNode.get("turnovers").asInt());
            statsPlayer.setBlocks(playerStatisticsNode.get("blocks").asInt());
            statsPlayer.setPlusMinus(playerStatisticsNode.get("plusMinus").asInt());
            statsPlayerRepository.save(statsPlayer);
        }
    }
}