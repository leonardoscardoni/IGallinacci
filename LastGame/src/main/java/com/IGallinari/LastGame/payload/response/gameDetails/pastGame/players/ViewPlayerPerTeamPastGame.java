package com.IGallinari.LastGame.payload.response.gameDetails.pastGame.players;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ViewPlayerPerTeamPastGame {
    private List<ViewPlayerPastGame> homeTeam;
    private List<ViewPlayerPastGame> visitorTeam;
}
