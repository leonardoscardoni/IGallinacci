package com.IGallinari.LastGame.payload.response.TeamDetails;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewStatsPlayerTeamDetails {
    private Integer pointsForGame;
    private Integer assist;
    private Integer rebounds;
    private Integer steals;
    private Integer blocks;
}
