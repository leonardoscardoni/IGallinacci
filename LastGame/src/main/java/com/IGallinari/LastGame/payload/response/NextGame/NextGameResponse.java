package com.IGallinari.LastGame.payload.response.NextGame;

import com.IGallinari.LastGame.payload.response.NextGame.GameDetails.ViewGameDetails;
import com.IGallinari.LastGame.payload.response.NextGame.LastFourGames.ViewLastFourGames;
import com.IGallinari.LastGame.payload.response.NextGame.LastFourHtH.LastFourHtH;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NextGameResponse {
    private ViewGameDetails gameDetails;
    private ViewLastFourGames viewLastFourGamesHome;
    private ViewLastFourGames viewLastFourGamesVisitor;
    private LastFourHtH lastFourHtHHome;
    private LastFourHtH lastFourHtHVisitor;
}
