package com.IGallinari.LastGame.payload.response.gameDetails.lastFourHtH;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class LastFourHtHGameDetails {
    private int idTeam;
    private String code;
    private String logo;
    private List<HeadToHeadGameDetails> headToHeadGameDetails;
}
