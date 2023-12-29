package com.IGallinari.LastGame.payload.response.ListTeam;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeamsNoConferenceResponse {
    private ViewDivision atlantic;
    private ViewDivision central;
    private ViewDivision northwest;
    private ViewDivision pacific;
    private ViewDivision southeast;
    private ViewDivision southwest;
}
