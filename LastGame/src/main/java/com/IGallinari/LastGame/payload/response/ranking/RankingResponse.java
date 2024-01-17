package com.IGallinari.LastGame.payload.response.ranking;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor

public class RankingResponse {
    private List<ViewTeamRanking> eastTeams;
    private List<ViewTeamRanking> westTeams;
}
