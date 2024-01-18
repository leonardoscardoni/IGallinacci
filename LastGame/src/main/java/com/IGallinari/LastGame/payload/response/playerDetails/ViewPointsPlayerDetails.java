package com.IGallinari.LastGame.payload.response.playerDetails;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewPointsPlayerDetails {
    private Integer totalPoints;
    private Float pointsPerGame;
}
