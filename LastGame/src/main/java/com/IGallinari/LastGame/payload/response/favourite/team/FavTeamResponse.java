package com.IGallinari.LastGame.payload.response.favourite.team;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FavTeamResponse {
    private int idTeam;
    private boolean favourite;
}
