package com.IGallinari.LastGame.payload.response.DetailsPlayerIndependByGame;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewGamesDetailsPlayerIndependentByGame {
    private Integer gamesPlayed;
    private Integer jerseyNumber;
    private Integer averageScore;
    private Integer seasonScore;
}
