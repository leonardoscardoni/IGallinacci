package com.IGallinari.LastGame.payload.response.playerDetailsByGame;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ViewPlayerInfoPlayerDetailsByGame {
    private boolean favourite;
    private int idTeam;
    private String firstname;
    private String lastname;
    private String logo;
    private String pos;
}
