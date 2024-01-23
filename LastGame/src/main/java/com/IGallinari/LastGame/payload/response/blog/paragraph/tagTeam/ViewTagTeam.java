package com.IGallinari.LastGame.payload.response.blog.paragraph.tagTeam;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewTagTeam {
    private int idTeam;
    private String name;
    private String nickname;
    private String code;
    private String logo;
}
