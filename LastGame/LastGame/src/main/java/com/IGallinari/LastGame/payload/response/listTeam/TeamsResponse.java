package com.IGallinari.LastGame.payload.response.listTeam;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeamsResponse {
    private ViewConferenceWest west;
    private ViewConferenceEast east;
}
