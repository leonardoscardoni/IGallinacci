package com.IGallinari.LastGame.payload.response.NextGame.GameDetails;

import java.time.LocalDate;
import java.time.LocalTime;

public class ViewGameDetails {
    private int id;
    private String arena;
    private String city;
    private LocalDate date;
    private LocalTime time;
    private ViewTeamDetails homeTeam;
    private ViewTeamDetails visitorTeam;
}
