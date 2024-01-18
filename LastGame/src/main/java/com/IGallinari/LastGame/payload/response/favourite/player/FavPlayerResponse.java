package com.IGallinari.LastGame.payload.response.favourite.player;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FavPlayerResponse {
    private int idPlayer;
    private boolean favourite;
}
