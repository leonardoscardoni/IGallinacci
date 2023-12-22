package com.IGallinari.LastGame.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HomeGamesResponse {
    String nicknameHomeTeam;
    String logoHomeTeam;
    int pointsHomeTeams;
    String nicknameVisitorTeam;
    String logoVisitorTeam;
    int pointsVisitorTeams;
}