package com.IGallinari.LastGame.payload.response.teamDetails;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewPlayerTeamDetails {
    private int idPlayer;
    private String firstname;
    private String lastname;
    private Integer number;
    private String position;
    private ViewStatsPlayerTeamDetails stats;
}
