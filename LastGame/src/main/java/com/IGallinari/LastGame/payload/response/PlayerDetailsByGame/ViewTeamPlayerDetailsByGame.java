package com.IGallinari.LastGame.payload.response.PlayerDetailsByGame;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ViewTeamPlayerDetailsByGame {
    private String name;
    private String logo;
    private Integer points;

}
