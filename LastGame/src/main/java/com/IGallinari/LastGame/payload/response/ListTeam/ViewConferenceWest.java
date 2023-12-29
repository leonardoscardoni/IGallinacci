package com.IGallinari.LastGame.payload.response.ListTeam;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewConferenceWest {
    private ViewDivision northwest;
    private ViewDivision pacific;
    private ViewDivision southwest;
}