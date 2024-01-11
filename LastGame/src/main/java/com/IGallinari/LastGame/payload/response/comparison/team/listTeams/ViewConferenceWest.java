package com.IGallinari.LastGame.payload.response.comparison.team.listTeams;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewConferenceWest {
    private ViewDivision northwest;
    private ViewDivision pacific;
    private ViewDivision southwest;
}