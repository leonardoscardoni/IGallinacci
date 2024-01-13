package com.IGallinari.LastGame.payload.response.home;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class HomeResponse {
    private List<ViewPastGame> pastGames;
    private List<ViewNextGame> nextGames;

}
