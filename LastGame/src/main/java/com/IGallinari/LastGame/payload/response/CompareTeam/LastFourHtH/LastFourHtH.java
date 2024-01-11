package com.IGallinari.LastGame.payload.response.CompareTeam.LastFourHtH;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class LastFourHtH {
    private int idTeam;
    private String code;
    private String logo;
    private List<HeadToHead> headToHeads;
}
