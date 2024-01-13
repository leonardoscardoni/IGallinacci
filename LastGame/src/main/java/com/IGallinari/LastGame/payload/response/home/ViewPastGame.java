package com.IGallinari.LastGame.payload.response.home;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewPastGame {
    private int id;
    private ViewPastTeam homeTeam;
    private ViewPastTeam visitorTeam;
}
