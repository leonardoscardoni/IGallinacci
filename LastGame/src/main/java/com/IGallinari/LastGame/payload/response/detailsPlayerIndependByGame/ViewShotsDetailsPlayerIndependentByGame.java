package com.IGallinari.LastGame.payload.response.detailsPlayerIndependByGame;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewShotsDetailsPlayerIndependentByGame {
    private Integer fieldShotsScored;
    private Integer fieldShotsAttempted;
    private Integer fieldShotsPercentage;
    private Integer freeThrowsScored;
    private Integer freeThrowsAttempted;
    private Integer freeThrowsPercentage;
    private Integer threePointersShotsScored;
    private Integer threePointersShotsAttempted;
    private Integer threePointersShotsPercentage;
}
