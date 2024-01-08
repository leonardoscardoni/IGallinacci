package com.IGallinari.LastGame.payload.response.TeamDetails;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TeamDetailsResponse {
    private String name;
    private String conference;
    private String division;
    private Integer rankConference;
    private Integer rankDivision;
    private ViewStatsTeamDetails stats;
    private List<ViewPlayerTeamDetails> players;
    private ViewShotTeamDetails shots;
    private ViewAssistReboundsTeamDetails assistRebounds;
    private ViewPointsTeamDetails points;
    private ViewFoulsBallsBlocksTeamDetails foulsBallsBlocks;
    private ViewWinLossTeamDetails winLoss;
}
