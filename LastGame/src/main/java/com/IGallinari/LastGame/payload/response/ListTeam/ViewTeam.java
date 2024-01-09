package com.IGallinari.LastGame.payload.response.ListTeam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class ViewTeam {
    private int id;
    private String nickname;
    private String name;
    private String logo;
    private boolean favourite;
}
