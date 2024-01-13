package com.IGallinari.LastGame.payload.response.comparison.team;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewTeamComparisonNbaAvgCompareTeam {
    private String dataName;
    private Integer dataTeam1;
    private Integer datateam2;
}
