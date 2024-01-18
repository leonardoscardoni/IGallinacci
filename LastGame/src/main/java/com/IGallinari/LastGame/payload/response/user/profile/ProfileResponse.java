package com.IGallinari.LastGame.payload.response.user.profile;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProfileResponse {
    private Integer idUser;
    private String userName;
    private List<ViewFavoritePlayerProfileResponse> favPlayers;
    private List<ViewFavoriteTeamProfileResponse> favTeam;
}
