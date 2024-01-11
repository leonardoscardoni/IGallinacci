package com.IGallinari.LastGame.payload.response.gameDetails.nextGame.lastFourGames;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ViewLastFourGamesNextGame {
    private int idTeam;
    private String code;
    private String logo;
    private List<ViewLastGameNextGame> lastGames;
}
