package com.IGallinari.LastGame.payload.response.CompareTeam;

import com.IGallinari.LastGame.payload.response.CompareTeam.LastFourGames.ViewLastFourGames;
import com.IGallinari.LastGame.payload.response.CompareTeam.LastFourHtH.LastFourHtH;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CompareTeamResponse {
    private ViewTeamCompareTeam team1;
    private ViewTeamCompareTeam team2;
    private List<ViewTeamComparisonNbaAvgCompareTeam> dataCompareTeamNba;
    private ViewLastFourGames Viewlast4GamesTeam1;
    private ViewLastFourGames Viewlast4GamesTeam2;
    private LastFourHtH lastFourHtHTeam1;
    private LastFourHtH lastFourHtHTeam2;
}
