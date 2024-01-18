package com.IGallinari.LastGame.payload.response.standings;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor

public class StandingsResponse {
    private boolean logged;
    private List<ViewTeamStanding> eastTeams;
    private List<ViewTeamStanding> westTeams;
}
