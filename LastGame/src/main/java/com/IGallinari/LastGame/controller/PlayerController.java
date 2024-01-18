package com.IGallinari.LastGame.controller;



import com.IGallinari.LastGame.payload.request.TokenRequest;
import com.IGallinari.LastGame.payload.response.playerDetails.PlayerDetailsResponse;
import com.IGallinari.LastGame.payload.response.comparison.player.ComparePlayerResponse;
import com.IGallinari.LastGame.payload.response.listPlayerFilter.PlayerFilterResponse;
import com.IGallinari.LastGame.payload.response.playerDetailsByGame.PlayerDetailsByGameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.IGallinari.LastGame.payload.response.playerTeamFilter.PlayerTeamFilterResponse;
import com.IGallinari.LastGame.service.PlayerService;

@RestController
@RequestMapping("/player")
@CrossOrigin
public class PlayerController {
    
    @Autowired
    private PlayerService service;

    @PostMapping("/getPlayerFilteredByTeam")
    public PlayerTeamFilterResponse getPlayerTeamFilter(@RequestBody  TokenRequest tokenRequest, @RequestParam int idTeam, @RequestParam int season){return this.service.buildPlayerTeamFilterResponse(tokenRequest,idTeam, season);}

    @PostMapping("/getPlayerDetailsByGame")
    public PlayerDetailsByGameResponse getPlayerDetailsByGame (@RequestBody TokenRequest tokenRequest,@RequestParam int idGame, @RequestParam int idPlayer){return this.service.buildPlayerDetailsByGameResponse(tokenRequest,idGame, idPlayer);}

    @RequestMapping("getTeamRolesPlayerFilter")
    public PlayerFilterResponse getTeamRolesPlayerFilter(){return this.service.buildCompareFilterResponse();}

    @PostMapping("getPlayerDetails")
    public PlayerDetailsResponse getPlayerDetails(@RequestBody TokenRequest tokenRequest, @RequestParam int idPlayer, int season){return this.service.buildDetailsPlayerIndependentByGameResponse(tokenRequest,idPlayer, season);}

    @RequestMapping("getPlayerCompare")
    public ComparePlayerResponse getPlayerCompare(@RequestParam int idPlayer1,@RequestParam int idPlayer2,@RequestParam int season){return this.service.buildComparePlayerResponse(idPlayer1, idPlayer2, season);}
}
