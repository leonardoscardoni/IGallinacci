package com.IGallinari.LastGame.payload.response.TeamDetails;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewWinLossTeamDetails {
    private Integer victoriesAtHome;
    private Integer defeatsAtHome;
}
