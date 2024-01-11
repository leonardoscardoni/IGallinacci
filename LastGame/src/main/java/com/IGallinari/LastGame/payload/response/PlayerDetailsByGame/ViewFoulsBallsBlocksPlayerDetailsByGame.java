package com.IGallinari.LastGame.payload.response.PlayerDetailsByGame;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ViewFoulsBallsBlocksPlayerDetailsByGame {
    private Integer foulsCommitted;
    private Integer steals;
    private Integer turnovers;
    private Integer blocks;
}
