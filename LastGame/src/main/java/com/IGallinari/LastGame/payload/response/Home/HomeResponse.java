package com.IGallinari.LastGame.payload.response.Home;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class HomeResponse {
    private List<pastResultGame> pastGame;
    private List<nextResultGame> nextGame;

}
