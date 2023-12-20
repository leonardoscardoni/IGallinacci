package com.IGallinari.LastGame.service.API_to_DB.HandleJSON;

import com.IGallinari.LastGame.entity.StatsPlayer;
import com.IGallinari.LastGame.repository.GameRepository;
import com.IGallinari.LastGame.repository.PlayerRepository;
import com.IGallinari.LastGame.repository.StatsPlayerRepository;
import com.IGallinari.LastGame.repository.TeamRepository;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlayersStatisticsHandler implements Handler{
    private GameRepository gameRepository;

    private TeamRepository teamRepository;

    private PlayerRepository playerRepository;

    private StatsPlayerRepository statsPlayerRepository;

    @Override
    public void handle(JsonNode jsonNode) {
        JsonNode playersStatisticsNode = jsonNode.get("response").get(0);

        for (JsonNode playerStatisticsNode : playersStatisticsNode) {
            StatsPlayer statsPlayer = new StatsPlayer();
            statsPlayer.setGame(gameRepository.findById(playerStatisticsNode.get("game").get("id").asInt()));
            statsPlayer.setTeam(teamRepository.findById(playerStatisticsNode.get("team").get("id").asInt()));
            statsPlayer.setPlayer(playerRepository.findById(playerStatisticsNode.get("player").get("id").asInt()));
            statsPlayer.setPoints(asInteger(playerStatisticsNode.get("points")));
            statsPlayer.setPos(playerStatisticsNode.get("pos").asText(null));
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
        }
    }
}