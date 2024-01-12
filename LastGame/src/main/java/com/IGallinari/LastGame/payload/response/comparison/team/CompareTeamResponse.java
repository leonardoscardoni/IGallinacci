package com.IGallinari.LastGame.payload.response.comparison.team;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CompareTeamResponse {
    private ViewTeamCompareTeam team1;
    private ViewTeamCompareTeam team2;
    private List<ViewTeamComparisonNbaAvgCompareTeam> dataCompareTeamNba;
}
