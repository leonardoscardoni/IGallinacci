package com.IGallinari.LastGame.payload.response.comparison.player;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewDataPlayerComparePlayer {
    private String dataName;
    private Integer dataPlayer1;
    private Integer dataPlayer2; 
}
