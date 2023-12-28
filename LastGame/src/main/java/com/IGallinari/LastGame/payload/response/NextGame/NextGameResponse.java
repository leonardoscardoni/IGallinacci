package com.IGallinari.LastGame.payload.response.NextGame;

import com.IGallinari.LastGame.payload.response.NextGame.GameDetails.ViewGameDetails;
import com.IGallinari.LastGame.payload.response.NextGame.LastFourGames.LastFourGames;
import com.IGallinari.LastGame.payload.response.NextGame.LastFourHtH.LastFourHtH;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NextGameResponse {
    private ViewGameDetails gameDetails;
    private LastFourGames lastFourGamesHome;
    private LastFourGames lastFourGamesVisitor;
    private LastFourHtH lastFourHtHHome;
    private LastFourHtH lastFourHtHVisitor;
}
