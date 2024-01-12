package com.IGallinari.LastGame.payload.response.teamDetails;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewStatsPlayerTeamDetails {
    private Float pointsForGame;
    private Float assist;
    private Float rebounds;
    private Float steals;
    private Float blocks;
}
