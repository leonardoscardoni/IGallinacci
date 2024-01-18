package com.IGallinari.LastGame.payload.response.user.profile;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewFavoritePlayerProfileResponse {
    private int idPlayer;
    private String firstname;
    private String lastname;
    private Integer numShirt;
    private String pos;
    private ViewStatisticsFavPlayerProfileResponse statFavPlayer;

}
