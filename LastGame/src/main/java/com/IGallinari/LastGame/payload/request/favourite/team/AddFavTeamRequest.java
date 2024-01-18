package com.IGallinari.LastGame.payload.request.favourite.team;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddFavTeamRequest {
    private String token;
    private int idTeam;
}
