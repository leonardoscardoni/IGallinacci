package com.IGallinari.LastGame.payload.response.ListPlayerFilter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewTeamsPlayerFilter {
    private Integer idTeam;
    private String name;
}
