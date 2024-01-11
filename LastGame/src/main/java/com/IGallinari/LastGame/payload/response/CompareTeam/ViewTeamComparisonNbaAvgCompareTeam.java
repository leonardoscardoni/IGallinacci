package com.IGallinari.LastGame.payload.response.CompareTeam;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewTeamComparisonNbaAvgCompareTeam {
    private String dataName;
    private Integer dataTeam1;
    private Integer datateam2;
}
