package com.IGallinari.LastGame.payload.response.DetailsPlayerIndependByGame;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DetailsPlayerIndependentByGameResponse {
    private Boolean favouritePlayer;
    private int idPlayer;
    private String firstName;
    private String lastName;
    private int idTeam;
    private String logo;
    private String nameTeam;
    private ViewGamesDetailsPlayerIndependentByGame games;
    private ViewPlayerBioDetailsIndependentByGame playerBio;
    private ViewShotsDetailsPlayerIndependentByGame shots;
    private ViewAssistReboundsDetailsPlayerIndependentByGame assistRebounds;
    private ViewFoulsBallsBlocksDetailsPlayerIndependentByGame foulsBallsBlocks;
    private ViewPointsDetailsPlayerIndependentByGame points;
}
