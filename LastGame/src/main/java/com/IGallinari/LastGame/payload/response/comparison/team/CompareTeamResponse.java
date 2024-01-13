package com.IGallinari.LastGame.payload.response.comparison.team;

import com.IGallinari.LastGame.payload.response.lastFourGames.ViewLastFourGames;
import com.IGallinari.LastGame.payload.response.lastFourHtH.HeadToHead;
import com.IGallinari.LastGame.payload.response.lastFourHtH.LastFourHtH;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CompareTeamResponse {
    private ViewTeamCompareTeam team1;
    private ViewTeamCompareTeam team2;
    private List<ViewTeamComparisonNbaAvgCompareTeam> dataCompareTeamNba;
    private ViewLastFourGames lastFourGamesTeam1;
    private ViewLastFourGames lastFourGamesTeam2;
    private LastFourHtH lastFourHtHTeam1;
    private LastFourHtH lastFourHtHTeam2;
}
