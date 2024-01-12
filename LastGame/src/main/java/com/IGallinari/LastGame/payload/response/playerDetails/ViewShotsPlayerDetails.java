package com.IGallinari.LastGame.payload.response.playerDetails;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewShotsPlayerDetails {
    private Integer fieldShotsScored;
    private Integer fieldShotsAttempted;
    private Float fieldShotsPercentage;
    private Integer freeThrowsScored;
    private Integer freeThrowsAttempted;
    private Float freeThrowsPercentage;
    private Integer threePointersShotsScored;
    private Integer threePointersShotsAttempted;
    private Float threePointersShotsPercentage;
}
