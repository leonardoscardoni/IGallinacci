package com.IGallinari.LastGame.payload.response.Home;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class HomeResponse {
    private List<PastResultGame> pastGame;
    private List<NextViewGame> nextGame;

}
