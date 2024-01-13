package com.IGallinari.LastGame.payload.response.playerDetailsByGame;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ViewStatsPlayerDetailsByGame {
    private Integer min;
    private Integer score;
    private Integer totalRebounds;
    private Integer assists;

}
