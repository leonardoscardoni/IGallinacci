package com.IGallinari.LastGame.payload.response.teamDetails;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewStatsPlayerDetails {
    private Integer pointsForGame;
    private Integer assist;
    private Integer rebounds;
    private Integer steals;
    private Integer blocks;
    
}
