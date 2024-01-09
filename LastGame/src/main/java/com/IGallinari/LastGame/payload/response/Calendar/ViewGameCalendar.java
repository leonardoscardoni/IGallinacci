package com.IGallinari.LastGame.payload.response.Calendar;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.security.PrivateKey;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class ViewGameCalendar {
    private int id;
    private boolean played;
    private LocalDate date;
    private LocalTime time;
    private ViewTeamCalendar homeTeam;
    private ViewTeamCalendar visitorTeam;
}
