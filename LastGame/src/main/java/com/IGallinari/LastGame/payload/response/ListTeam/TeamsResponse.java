package com.IGallinari.LastGame.payload.response.ListTeam;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeamsResponse {
    private ViewConferenceWest west;
    private ViewConferenceEast east;
}
