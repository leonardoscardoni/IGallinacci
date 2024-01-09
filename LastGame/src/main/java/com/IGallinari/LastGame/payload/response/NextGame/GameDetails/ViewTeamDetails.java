package com.IGallinari.LastGame.payload.response.NextGame.GameDetails;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewTeamDetails {
    private int id;
    private String nickname;
    private String logo;
}
