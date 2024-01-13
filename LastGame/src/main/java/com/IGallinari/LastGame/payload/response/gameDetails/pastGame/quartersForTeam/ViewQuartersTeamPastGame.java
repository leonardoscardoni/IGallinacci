package com.IGallinari.LastGame.payload.response.gameDetails.pastGame.quartersForTeam;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewQuartersTeamPastGame {
    private Integer[] quarters;
}
