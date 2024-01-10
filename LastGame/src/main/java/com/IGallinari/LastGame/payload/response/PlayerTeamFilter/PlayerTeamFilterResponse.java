package com.IGallinari.LastGame.payload.response.PlayerTeamFilter;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class PlayerTeamFilterResponse {
    private int idTeam;
    private String nickname;
    private String name;
    private Integer season;
    private List<ViewPlayersPlayerTeamFilter> players;
}