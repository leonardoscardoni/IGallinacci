package com.IGallinari.LastGame.payload.response.gameDetails.pastGame.pestPlayers;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewBestPlayerPastGame {
    private int idPlayer;
    private String firstname;
    private String lastname;
    private Integer number;
    private Integer data;
    private String type;
}
