package com.IGallinari.LastGame.payload.response.playerTeamFilter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ViewPlayersPlayerTeamFilter {
    private boolean favourite;
    private Integer idPlayer;
    private String firstname;
    private String lastname;
    private String role;
    private Integer number;
    private String country;
}
