package com.IGallinari.LastGame.controller;
import com.IGallinari.LastGame.entity.Game;
import com.IGallinari.LastGame.payload.request.HomeGamesResponse;
import com.IGallinari.LastGame.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/games")
@CrossOrigin
public class GameController {
    private GameService service;
    @Autowired
    public GameController(GameService service) {
        this.service = service;
    }
    @PostMapping("/getHomeResults")
    public List<HomeGamesResponse> getGamesHome(){
         List<Game> games =this.service.getGamesHome();
         List<HomeGamesResponse> gamesResponse = Collections.emptyList();
         /*FORSE E MEGLIO FARLO SU GAMESTATS VISTO CHE HA IL COLLEGAMENTO SIA A GAME E (indirettamente) CON TEAM capire se fattibile
         for(Game game: games){
            gamesResponse.add(new HomeGamesResponse(
                    game.getVisitorTeam().getNickname(),
                    game.getVisitorTeam().getLogo(),
                    game.
            ))
         }*/
         return null;
    }
}

