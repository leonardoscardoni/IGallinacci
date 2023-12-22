package com.IGallinari.LastGame.payload.response.Home;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class nextResultGame {
    private int id;
    private nextResultTeam homeTeam;
    private nextResultTeam visitorTeam;
}
