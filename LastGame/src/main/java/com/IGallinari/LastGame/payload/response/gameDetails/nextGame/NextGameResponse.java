package com.IGallinari.LastGame.payload.response.gameDetails.nextGame;

import com.IGallinari.LastGame.payload.response.gameDetails.nextGame.gameDetails.ViewGameDetailsNextGame;
import com.IGallinari.LastGame.payload.response.gameDetails.nextGame.lastFourGames.ViewLastFourGamesNextGame;
import com.IGallinari.LastGame.payload.response.gameDetails.lastFourHtH.LastFourHtHGameDetails;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NextGameResponse {
    private ViewGameDetailsNextGame gameDetails;
    private ViewLastFourGamesNextGame viewLastFourGamesNextGameHome;
    private ViewLastFourGamesNextGame viewLastFourGamesNextGameVisitor;
    private LastFourHtHGameDetails lastFourHtHGameDetailsHome;
    private LastFourHtHGameDetails lastFourHtHGameDetailsVisitor;
}
