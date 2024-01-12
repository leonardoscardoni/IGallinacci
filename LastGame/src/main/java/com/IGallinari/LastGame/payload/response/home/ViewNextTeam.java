package com.IGallinari.LastGame.payload.response.home;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewNextTeam {
    private int id;
    private String nickname;
    private String logo;
}
