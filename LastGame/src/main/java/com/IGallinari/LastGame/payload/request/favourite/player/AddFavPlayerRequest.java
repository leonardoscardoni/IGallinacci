package com.IGallinari.LastGame.payload.request.favourite.player;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddFavPlayerRequest {
    private String token;
    private int idPlayer;
}
