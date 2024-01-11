package com.IGallinari.LastGame.payload.response.CompareTeam.LastFourGames;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewLastGame {
    private int idGame;
    private boolean result;
}
