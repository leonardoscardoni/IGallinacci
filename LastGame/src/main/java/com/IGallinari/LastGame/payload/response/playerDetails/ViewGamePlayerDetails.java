package com.IGallinari.LastGame.payload.response.playerDetails;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewGamePlayerDetails {
    private Integer gamesPlayed;
    private Integer jerseyNumber;
    private Float averageScore;
    private Integer seasonScore;
}
