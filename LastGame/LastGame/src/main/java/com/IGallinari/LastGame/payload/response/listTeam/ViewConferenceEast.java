package com.IGallinari.LastGame.payload.response.listTeam;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewConferenceEast {
    private ViewDivision atlantic;
    private ViewDivision central;
    private ViewDivision southeast;
}
