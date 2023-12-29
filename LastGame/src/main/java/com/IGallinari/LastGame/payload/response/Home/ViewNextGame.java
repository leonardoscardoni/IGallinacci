package com.IGallinari.LastGame.payload.response.Home;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;

@Data
@AllArgsConstructor
public class ViewNextGame {
    private int id;
    private LocalTime time;
    private ViewNextTeam homeTeam;
    private ViewNextTeam visitorTeam;
}
