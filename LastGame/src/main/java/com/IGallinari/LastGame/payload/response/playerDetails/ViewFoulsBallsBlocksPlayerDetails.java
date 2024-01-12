package com.IGallinari.LastGame.payload.response.playerDetails;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewFoulsBallsBlocksPlayerDetails {
    private Integer foulsCommitted;
    private Integer steals;
    private Integer turnovers;
    private Integer blocks;
}
