package com.IGallinari.LastGame.payload.response.teamDetails;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewPlayerComparisonNbaAvgTeamDetails {
    private String dataName;
    private Integer dataTeam;
    private Float dataNba;
}
