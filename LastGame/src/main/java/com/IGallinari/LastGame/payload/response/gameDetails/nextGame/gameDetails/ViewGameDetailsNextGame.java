package com.IGallinari.LastGame.payload.response.gameDetails.nextGame.gameDetails;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class ViewGameDetailsNextGame {
    private int id;
    private String arena;
    private String city;
    private LocalDate date;
    private LocalTime time;
    private ViewTeamDetailsNextGame homeTeam;
    private ViewTeamDetailsNextGame visitorTeam;
}
