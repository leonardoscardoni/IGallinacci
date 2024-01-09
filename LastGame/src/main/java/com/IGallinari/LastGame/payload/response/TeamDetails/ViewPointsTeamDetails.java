package com.IGallinari.LastGame.payload.response.TeamDetails;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewPointsTeamDetails {
    private Integer totalPoints;
    private Integer pointsPerGame;
    private Integer pointsAllowedPerGame;
}
