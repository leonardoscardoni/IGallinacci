package com.IGallinari.LastGame.payload.response.Home;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class pastResultGame {
    private int id;
    private pastResultTeam homeTeam;
    private pastResultTeam visitorTeam;
}
