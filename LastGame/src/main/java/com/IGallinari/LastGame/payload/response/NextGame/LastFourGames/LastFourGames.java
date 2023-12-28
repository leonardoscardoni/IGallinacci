package com.IGallinari.LastGame.payload.response.NextGame.LastFourGames;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class LastFourGames {
    private int idTeam;
    private String code;
    private String logo;
    private List<ViewLastGame> lastGames;
}
