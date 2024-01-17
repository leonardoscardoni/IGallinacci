package com.IGallinari.LastGame.payload.response.playerDetails;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewShotsPlayerDetails {
    private Integer fieldGoalsMade;
    private Integer fieldGoalsAttempted;
    private Float fieldGoalsPercentage;
    private Integer freeTrowMade;
    private Integer freeTrowAttempted;
    private Float freeTrowPercentage;
    private Integer threePointersMade;
    private Integer threePointersAttempted;
    private Float threePointersPercentage;
}
