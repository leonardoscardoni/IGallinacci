package com.IGallinari.LastGame.payload.response.gameDetails.pastGame.gameDetails;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class ViewGameDetailsPastGame {
    private int id;
    private String arena;
    private String city;
    private LocalDate date;
    private LocalTime time;
    private ViewTeamDetailsPastGame homeTeam;
    private ViewTeamDetailsPastGame visitorTeam;
}
