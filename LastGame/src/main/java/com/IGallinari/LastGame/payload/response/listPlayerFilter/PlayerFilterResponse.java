package com.IGallinari.LastGame.payload.response.listPlayerFilter;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PlayerFilterResponse {
    private List<ViewTeamsPlayerFilter> teamList;
    private List<ViewRolesPlayerFilter> rolePlayer;
}
