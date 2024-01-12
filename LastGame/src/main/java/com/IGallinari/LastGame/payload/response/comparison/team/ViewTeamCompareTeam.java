package com.IGallinari.LastGame.payload.response.comparison.team;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewTeamCompareTeam {
    private int idTeam;
    private String name;
    private String logo;
    private String conference;
    private Integer rankConference;
}
