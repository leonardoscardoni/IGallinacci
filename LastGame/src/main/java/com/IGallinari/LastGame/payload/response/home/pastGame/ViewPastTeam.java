package com.IGallinari.LastGame.payload.response.home.pastGame;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewPastTeam {
    private int id;
    private String nickname;
    private String logo;
    private Integer points;
}