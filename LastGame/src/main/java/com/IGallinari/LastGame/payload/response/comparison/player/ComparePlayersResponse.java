package com.IGallinari.LastGame.payload.response.comparison.player;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ComparePlayersResponse {
    private ViewHeaderComparePlayer player1;
    private ViewHeaderComparePlayer player2;
    private List<ViewPlayerComparePlayer> comparisonPlayers;
    private List<ViewDataPlayerComparePlayer> dataPlayers;
}
