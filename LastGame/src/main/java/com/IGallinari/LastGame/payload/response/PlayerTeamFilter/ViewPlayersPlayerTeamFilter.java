package com.IGallinari.LastGame.payload.response.PlayerTeamFilter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ViewPlayersPlayerTeamFilter {
    private Integer idPlayer;
    private String name;
    private String ruolo;
    private Integer number;
    private String country;
    private boolean favourite;
}
