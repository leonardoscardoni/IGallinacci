package com.IGallinari.LastGame.payload.response.teamDetails;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewPointsTeamDetails {
    private Integer totalPoints;
    private Float pointsPerGame;
    private Float pointsAllowedPerGame;
}
