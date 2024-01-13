package com.IGallinari.LastGame.payload.response.gameDetails.pastGame.pestPlayers;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ViewBestPlayersPerTeamPastGame {
    private List<ViewBestPlayerPastGame> homeTeam;
    private List<ViewBestPlayerPastGame> visitorTeam;
}
