package com.IGallinari.LastGame.payload.response.Home;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PastResultGame {
    private int id;
    private PastResultTeam homeTeam;
    private PastResultTeam visitorTeam;
}
