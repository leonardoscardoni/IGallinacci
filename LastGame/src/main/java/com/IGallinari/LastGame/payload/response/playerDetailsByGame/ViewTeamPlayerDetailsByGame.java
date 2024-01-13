package com.IGallinari.LastGame.payload.response.playerDetailsByGame;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ViewTeamPlayerDetailsByGame {
    private String name;
    private String logo;
    private Integer points;

}
