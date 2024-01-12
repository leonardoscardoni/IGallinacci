package com.IGallinari.LastGame.payload.response.detailsPlayerIndependByGame;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewPointsDetailsPlayerIndependentByGame {
    private Integer totalPoints;
    private Integer pointsByGame;
}
