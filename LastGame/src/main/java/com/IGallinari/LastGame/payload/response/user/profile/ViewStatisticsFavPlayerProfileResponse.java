package com.IGallinari.LastGame.payload.response.user.profile;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewStatisticsFavPlayerProfileResponse {
    private Float pointsForGames;
    private Float asistForGames;
    private Float reboundsForGames;
    private Float stealsForGames;
}
