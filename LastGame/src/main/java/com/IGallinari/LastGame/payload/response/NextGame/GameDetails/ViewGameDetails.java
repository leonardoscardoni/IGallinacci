package com.IGallinari.LastGame.payload.response.NextGame.GameDetails;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class ViewGameDetails {
    private int id;
    private String arena;
    private String city;
    private LocalDate date;
    private LocalTime time;
    private ViewTeamDetails homeTeam;
    private ViewTeamDetails visitorTeam;
}
