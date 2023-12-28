package com.IGallinari.LastGame.payload.response.Home;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PastViewGame {
    private int id;
    private PastViewTeam homeTeam;
    private PastViewTeam visitorTeam;
}
