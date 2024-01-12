package com.IGallinari.LastGame.payload.response.teamDetails;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewTeamDetails {
    private String name;
    private String conference;
    private String division;
    private Integer rankConference;
    private Integer rankDivision;

}
