package com.IGallinari.LastGame.payload.response.comparison.player;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ViewHeaderComparePlayer {
    private int idPlayer;
    private String firstname;
    private String lastname;
    private String logo;
}
