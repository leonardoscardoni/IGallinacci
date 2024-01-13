package com.IGallinari.LastGame.payload.response.playerDetails;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlayerDetailsResponse {
    private Boolean favourite;
    private int idPlayer;
    private String firstName;
    private String lastName;
    private int idTeam;
    private String logo;
    private String nameTeam;
    private ViewGamePlayerDetails games;
    private ViewPlayerBioPlayerDetails playerBio;
    private ViewShotsPlayerDetails shots;
    private ViewAssistReboundsPlayerDetails assistRebounds;
    private ViewFoulsBallsBlocksPlayerDetails foulsBallsBlocks;
    private ViewPointsPlayerDetails points;
}
