package com.IGallinari.LastGame.payload.response.gameDetails.nextGame;

import com.IGallinari.LastGame.payload.response.lastFourGames.ViewLastFourGames;
import com.IGallinari.LastGame.payload.response.lastFourHtH.LastFourHtH;
import com.IGallinari.LastGame.payload.response.gameDetails.nextGame.gameDetails.ViewGameDetailsNextGame;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NextGameResponse {
    private boolean played;
    private ViewGameDetailsNextGame gameDetails;
    private ViewLastFourGames viewLastFourGamesNextGameHome;
    private ViewLastFourGames viewLastFourGamesNextGameVisitor;
    private LastFourHtH lastFourHtHHome;
    private LastFourHtH lastFourHtHVisitor;
}
