package com.IGallinari.LastGame.payload.response.listTeam;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ViewDivision {
    private List<ViewTeam> teams;
}
