package com.IGallinari.LastGame.payload.response.Home;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class pastResultTeam {
    private int id;
    private String nickname;
    private String logo;
    private int points;
}