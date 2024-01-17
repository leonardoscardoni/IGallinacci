package com.IGallinari.LastGame.payload.response.ranking;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ViewTeamRanking {
    private Integer rank;
    private int idTeam;
    private String logo;
    private String nickname;
    private Integer win;
    private Integer loss;
    private Integer winHome;
    private Integer winAway;
    private float averagePointsByGame;
    private float averagePointsConcededByGame;
    private Integer consecutiveWinsOrLosses;
}
