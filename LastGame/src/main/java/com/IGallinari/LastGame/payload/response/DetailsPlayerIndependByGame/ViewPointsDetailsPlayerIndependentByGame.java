package com.IGallinari.LastGame.payload.response.DetailsPlayerIndependByGame;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewPointsDetailsPlayerIndependentByGame {
    private Integer totalPoints;
    private Float pointsByGame;
}
