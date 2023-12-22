package com.IGallinari.LastGame.controller;

import com.IGallinari.LastGame.entity.StatsGame;
import com.IGallinari.LastGame.payload.response.Home.pastResultGame;
import com.IGallinari.LastGame.payload.response.Home.pastResultTeam;
import com.IGallinari.LastGame.service.StastsGameService;
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
public class StatsGameController {

    @Autowired
    private StastsGameService service;
    /*
    @PostMapping("/getHomeResults")
    public List<pastResultGame> getGamesHome(){
        List<StatsGame> statsGames =this.service.getGamesHome();
        List<pastResultGame> pastResultGames = Collections.emptyList();
         for(StatsGame statsGame: statsGames){
             pastResultGames.add(
                     new pastResultGame(
                             statsGame.getStatsGameId(),
                             new pastResultTeam(
                                     statsGame.getStatsGameId(),
                                     statsGame.getGame().getHomeTeam().getNickname(),
                                     statsGame.getGame().getHomeTeam().getLogo(),
                                     statsGame.
                                     )
                     )
             )

         }
        return null;
    }*/
}
