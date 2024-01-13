package com.IGallinari.LastGame.payload.response.lastFourGames;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ViewLastFourGames {
    private int idTeam;
    private String code;
    private String logo;
    private List<ViewLastGame> lastGames;
}
