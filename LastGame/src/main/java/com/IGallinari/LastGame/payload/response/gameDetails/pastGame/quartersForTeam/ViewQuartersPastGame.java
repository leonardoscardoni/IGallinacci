package com.IGallinari.LastGame.payload.response.gameDetails.pastGame.quartersForTeam;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewQuartersPastGame {
    private ViewQuartersTeamPastGame homeTeam;
    private ViewQuartersTeamPastGame visitorTeam;
}
