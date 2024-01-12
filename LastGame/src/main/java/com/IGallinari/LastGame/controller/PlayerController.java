package com.IGallinari.LastGame.controller;

import com.IGallinari.LastGame.payload.response.DetailsPlayerIndependByGame.DetailsPlayerIndependentByGameResponse;
import com.IGallinari.LastGame.payload.response.ListPlayerFilter.PlayerFilterResponse;
import com.IGallinari.LastGame.payload.response.PlayerDetailsByGame.PlayerDetailsByGameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.IGallinari.LastGame.payload.response.PlayerTeamFilter.PlayerTeamFilterResponse;
import com.IGallinari.LastGame.service.PlayerService;

@RestController
@RequestMapping("/player")
@CrossOrigin
public class PlayerController {
    
    @Autowired
    private PlayerService service;

    @RequestMapping("/getPlayerTeamFilter")
    public PlayerTeamFilterResponse getPlayerTeamFilter(@RequestParam int idTeam, @RequestParam int season){return this.service.buildPlayerTeamFilterResponse(idTeam, season);}

    @RequestMapping("/getPlayerDetailsByGame")
    public PlayerDetailsByGameResponse getPlayerDetailsByGame (@RequestParam int idGame, @RequestParam int idPlayer){return this.service.buildPlayerDetailsByGameResponse(idGame, idPlayer);}

    @RequestMapping("getTeamRolesPlayerFilter")
    public PlayerFilterResponse getTeamRolesPlayerFilter(){return this.service.buildCompareFilterResponse();}

    @RequestMapping("getPlayerByGame")
    public DetailsPlayerIndependentByGameResponse getPlayerByGame(@RequestParam int idGame, int idPlayer){return this.service.buildDetailsPlayerIndependentByGameResponse(idGame, idPlayer);}
}
