package com.IGallinari.LastGame.payload.response.Home;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class NextViewGame {
    private int id;
    private LocalTime time;
    private NextViewTeam homeTeam;
    private NextViewTeam visitorTeam;
}
