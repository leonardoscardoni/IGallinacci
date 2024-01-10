package com.IGallinari.LastGame.payload.response.PlayerDetailsByGame;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ViewAssistReboundsPlayerDetailsByGame {
    private Integer reboundsOffensive;
    private Integer reboundsDefensive;
    private Integer totalRebounds;
    private Integer assists;
}
