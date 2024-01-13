package com.IGallinari.LastGame.payload.response.gameDetails.pastGame.gameDetails;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewTeamDetailsPastGame {
    private int id;
    private String nickname;
    private String logo;
    private Integer points;
}
