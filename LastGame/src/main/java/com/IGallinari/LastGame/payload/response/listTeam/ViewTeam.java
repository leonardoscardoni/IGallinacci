package com.IGallinari.LastGame.payload.response.listTeam;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewTeam {
    private int id;
    private String nickname;
    private String name;
    private String logo;
    private boolean favourite;
}
