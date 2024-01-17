package com.IGallinari.LastGame.payload.response.user.profile;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewFavoriteTeamProfileResponse {
    private Integer idTeam;
    private String nickName;
    private String logo;
}
