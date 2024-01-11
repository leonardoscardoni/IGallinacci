package com.IGallinari.LastGame.payload.response.gameDetails.nextGame.lastFourGames;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewLastGameNextGame {
    private int idGame;
    private boolean result;
}
