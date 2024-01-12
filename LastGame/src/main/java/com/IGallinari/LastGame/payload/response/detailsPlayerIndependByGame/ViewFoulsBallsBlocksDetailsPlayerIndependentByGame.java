package com.IGallinari.LastGame.payload.response.detailsPlayerIndependByGame;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewFoulsBallsBlocksDetailsPlayerIndependentByGame {
    private Integer foulsCommitted;
    private Integer steals;
    private Integer turnovers;
    private Integer blocks;
}