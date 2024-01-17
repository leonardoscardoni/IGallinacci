package com.IGallinari.LastGame.payload.response.user.profile;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewFavoritePlayerProfileResponse {
    private String firstName;
    private String lastName;
    private Integer numShirt;
    private String pos;
    private ViewStatisticsFavPlayerProfileResponse statFavPlayer;

}
