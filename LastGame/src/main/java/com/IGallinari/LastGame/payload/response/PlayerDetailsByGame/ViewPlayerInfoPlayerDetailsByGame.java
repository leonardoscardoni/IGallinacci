package com.IGallinari.LastGame.payload.response.PlayerDetailsByGame;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ViewPlayerInfoPlayerDetailsByGame {
    private int idTeam;
    private String firstname;
    private String lastname;
    private String logo;
    private String pos;
}
