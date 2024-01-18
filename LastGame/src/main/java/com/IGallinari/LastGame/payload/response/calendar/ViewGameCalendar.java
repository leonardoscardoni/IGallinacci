package com.IGallinari.LastGame.payload.response.calendar;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class ViewGameCalendar {
    private int id;
    private LocalDate date;
    private LocalTime time;
    private ViewTeamCalendar homeTeam;
    private ViewTeamCalendar visitorTeam;
}
