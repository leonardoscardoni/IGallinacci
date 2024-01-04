package com.IGallinari.LastGame.service.API_to_DB.HandleJSON;

import com.IGallinari.LastGame.entity.*;
import com.IGallinari.LastGame.entity.id_class.IdPlayerTeam;
import com.IGallinari.LastGame.entity.id_class.IdStatsPlayer;
import com.IGallinari.LastGame.repository.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlayersStatisticsHandler implements Handler{
    private PlayerTeamRepository  playerTeamRepository;

    private PlayerRepository playerRepository;

    private GameRepository gameRepository;

    private StatsPlayerRepository statsPlayerRepository;

    @Override
    public void handle(JsonNode jsonNode) {
        ArrayNode playersStatisticsNode = (ArrayNode) jsonNode.get("response");
        JsonNode paramsNode = jsonNode.get("parameters");

        for (JsonNode playerStatisticsNode : playersStatisticsNode) {
            if(gameRepository.existsById(playerStatisticsNode.get("game").get("id").asInt())) {
                if (!playerRepository.existsById(playerStatisticsNode.get("player").get("id").asInt())) {
                    Player player = new Player();
                    player.setId(playerStatisticsNode.get("player").get("id").asInt());
                    player.setFirstname(asString(playerStatisticsNode.get("player").get("firstname")));
                    player.setLastname(asString(playerStatisticsNode.get("player").get("lastname")));
                    playerRepository.save(player);
                    IdPlayerTeam idPlayerTeam = new IdPlayerTeam();
                    idPlayerTeam.setSeason(paramsNode.get("season").asInt());
                    idPlayerTeam.setPlayerId(playerStatisticsNode.get("player").get("id").asInt());
                    idPlayerTeam.setTeamId(paramsNode.get("team").asInt());
                    PlayerTeam playerTeam = new PlayerTeam();
                    playerTeam.setIdPlayerTeam(idPlayerTeam);
                    playerTeamRepository.save(playerTeam);
                }
                StatsPlayer statsPlayer = new StatsPlayer();
                IdStatsPlayer idStatsPlayer = new IdStatsPlayer();
                idStatsPlayer.setPlayerId(playerStatisticsNode.get("player").get("id").asInt());
                idStatsPlayer.setGameId(playerStatisticsNode.get("game").get("id").asInt());
                idStatsPlayer.setTeamId(playerStatisticsNode.get("team").get("id").asInt());
                statsPlayer.setStatsPlayerId(idStatsPlayer);
                System.out.println("idPlayer: " + idStatsPlayer.getPlayerId());
                System.out.println("game: " + idStatsPlayer.getGameId());
                statsPlayer.setPoints(asInteger(playerStatisticsNode.get("points")));
                statsPlayer.setPos(asString(playerStatisticsNode.get("pos")));
                statsPlayer.setMin(asInteger(playerStatisticsNode.get("min")));
                statsPlayer.setFgm(asInteger(playerStatisticsNode.get("fgm")));
                statsPlayer.setFga(asInteger(playerStatisticsNode.get("fga")));
                statsPlayer.setFgp(asFloat(playerStatisticsNode.get("fgp")));
                statsPlayer.setFtm(asInteger(playerStatisticsNode.get("ftm")));
                statsPlayer.setFta(asInteger(playerStatisticsNode.get("fta")));
                statsPlayer.setFtp(asFloat(playerStatisticsNode.get("ftp")));
                statsPlayer.setTpm(asInteger(playerStatisticsNode.get("tpm")));
                statsPlayer.setTpa(asInteger(playerStatisticsNode.get("tpa")));
                statsPlayer.setTpp(asFloat(playerStatisticsNode.get("tpp")));
                statsPlayer.setOffReb(asInteger(playerStatisticsNode.get("offReb")));
                statsPlayer.setDefReb(asInteger(playerStatisticsNode.get("defReb")));
                statsPlayer.setTotReb(asInteger(playerStatisticsNode.get("totReb")));
                statsPlayer.setAssists(asInteger(playerStatisticsNode.get("assists")));
                statsPlayer.setPFouls(asInteger(playerStatisticsNode.get("pFouls")));
                statsPlayer.setSteals(asInteger(playerStatisticsNode.get("steals")));
                statsPlayer.setTurnovers(asInteger(playerStatisticsNode.get("turnovers")));
                statsPlayer.setBlocks(asInteger(playerStatisticsNode.get("blocks")));
                statsPlayer.setPlusMinus(asInteger(playerStatisticsNode.get("plusMinus")));
                statsPlayerRepository.save(statsPlayer);
                System.out.println("Object StatsPlayer statsPlayer saved in the DB");
            }
        }
    }
}
