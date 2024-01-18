package com.IGallinari.LastGame.payload.response.playerDetailsByGame;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class PlayerDetailsByGameResponse {
    private boolean logged;
    private int idGame;
    private ViewHeaderPlayerDetailsByGame header;
    private ViewTeamPlayerDetailsByGame homeTeam;
    private ViewTeamPlayerDetailsByGame visitorTeam;
    private ViewPlayerInfoPlayerDetailsByGame player;
    private ViewStatsPlayerDetailsByGame stats;
    private ViewShotsPlayerDetailsByGame shots;
    private ViewAssistReboundsPlayerDetailsByGame assistRebounds;
    private ViewFoulsBallsBlocksPlayerDetailsByGame foulsBallsBlocks;




}
