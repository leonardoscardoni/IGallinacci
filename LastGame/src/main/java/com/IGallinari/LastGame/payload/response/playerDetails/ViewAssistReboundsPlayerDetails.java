package com.IGallinari.LastGame.payload.response.playerDetails;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewAssistReboundsPlayerDetails {
    private Integer reboundsOffensive;
    private Integer reboundsDefensive;
    private Integer totalRebounds;
    private Integer assists;
}
