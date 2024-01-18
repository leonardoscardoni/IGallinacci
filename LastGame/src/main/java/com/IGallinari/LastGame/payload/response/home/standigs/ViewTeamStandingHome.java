package com.IGallinari.LastGame.payload.response.home.standigs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewTeamStandingHome {
    private int idTeam;
    private String nickname;
    private String logo;
    private Integer rank;
}
