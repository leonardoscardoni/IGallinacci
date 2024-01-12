package com.IGallinari.LastGame.payload.response.DetailsPlayerIndependByGame;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewAssistReboundsDetailsPlayerIndependentByGame {
    private Integer reboundsOffensive;
    private Integer reboundsDefensive;
    private Integer totalRebounds;
    private Integer assists;
}
