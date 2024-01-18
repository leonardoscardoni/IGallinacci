package com.IGallinari.LastGame.payload.response.gameDetails.nextGame.gameDetails;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewTeamDetailsNextGame {
    private boolean favourite;
    private int id;
    private String nickname;
    private String code;
    private String logo;
}
