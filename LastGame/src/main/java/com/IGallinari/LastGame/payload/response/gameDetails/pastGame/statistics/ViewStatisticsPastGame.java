package com.IGallinari.LastGame.payload.response.gameDetails.pastGame.statistics;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewStatisticsPastGame {
    private String statsType;
    private Integer homeTeamStats;
    private Integer visitorTeamStats;
}
