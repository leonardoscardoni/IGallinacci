package com.IGallinari.LastGame.payload.response.gameDetails.pastGame;

import com.IGallinari.LastGame.payload.response.lastFourHtH.LastFourHtH;
import com.IGallinari.LastGame.payload.response.gameDetails.pastGame.pestPlayers.ViewBestPlayersPerTeamPastGame;
import com.IGallinari.LastGame.payload.response.gameDetails.pastGame.gameDetails.ViewGameDetailsPastGame;
import com.IGallinari.LastGame.payload.response.gameDetails.pastGame.players.ViewPlayerPerTeamPastGame;
import com.IGallinari.LastGame.payload.response.gameDetails.pastGame.quartersForTeam.ViewQuartersPastGame;
import com.IGallinari.LastGame.payload.response.gameDetails.pastGame.statistics.ViewStatisticsPastGame;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PastGameResponse {
    private ViewGameDetailsPastGame gameDetails;
    private ViewQuartersPastGame quartersPerTeam;
    private List<ViewStatisticsPastGame> statistics;
    private ViewBestPlayersPerTeamPastGame bestPlayers;
    private LastFourHtH lastFourHtHGameDetailsHome;
    private LastFourHtH lastFourHtHGameDetailsVisitor;
    private ViewPlayerPerTeamPastGame players;
}
