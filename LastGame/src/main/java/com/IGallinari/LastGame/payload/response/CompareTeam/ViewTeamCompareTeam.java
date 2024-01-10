package com.IGallinari.LastGame.payload.response.CompareTeam;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewTeamCompareTeam {
    private String name;
    private String logo;
    private String conference;
    private Integer rankConference;
}
