package com.IGallinari.LastGame.payload.response.teamDetails;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewStatsTeamDetails {
    private Integer gamePlayed;
    private Integer points;
    private Float freeTrowMadePercentage;
    private Float threePointersMadePercentage;
}
