package com.IGallinari.LastGame.payload.response.PlayerDetailsByGame;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ViewShotsPlayerDetailsByGame {
    private Integer fieldGoalsMade;
    private Integer fieldGoalsAttempted;
    private Float fieldGoalsPercentage;
    private Integer freeThrowsMade;
    private Integer freeThrowsAttempted;
    private Float freeThrowsPercentage;
    private Integer threePointersMade;
    private Integer threePointersAttempted;
    private Float threePointersPercentage;
}
