package com.IGallinari.LastGame.payload.response.gameDetails.pastGame.players;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewPlayerPastGame {
    private boolean favourite;
    private int idPlayer;
    private String firstname;
    private String lastname;
    private Integer number;
    private String role;
}
