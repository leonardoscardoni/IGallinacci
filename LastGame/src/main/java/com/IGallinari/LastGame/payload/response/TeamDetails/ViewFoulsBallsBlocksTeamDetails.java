package com.IGallinari.LastGame.payload.response.TeamDetails;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewFoulsBallsBlocksTeamDetails {
    private Integer foulsCommitted;
    private Integer steals;
    private Integer turnovers;
    private Integer blocks;
}
