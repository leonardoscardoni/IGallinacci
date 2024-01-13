package com.IGallinari.LastGame.payload.response.lastFourGames;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewLastGame {
    private int idGame;
    private boolean result;
}
