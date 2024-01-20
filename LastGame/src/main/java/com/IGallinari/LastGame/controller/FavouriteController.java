package com.IGallinari.LastGame.controller;

import com.IGallinari.LastGame.payload.request.favourite.player.FavPlayerRequest;
import com.IGallinari.LastGame.payload.request.favourite.team.FavTeamRequest;
import com.IGallinari.LastGame.service.FavPlayerService;
import com.IGallinari.LastGame.service.FavTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/favourite")
@CrossOrigin
public class FavouriteController {

    @Autowired
    private FavTeamService favTeamService;
    @Autowired
    private FavPlayerService favPlayerService;

    @PostMapping("/team")
    public ResponseEntity<?> favTeam(@RequestBody FavTeamRequest favTeamRequest){return this.favTeamService.buildFavTeamResponse(favTeamRequest);}

    @PostMapping("/player")
    public ResponseEntity<?> favPlayer(@RequestBody FavPlayerRequest favPlayerRequest){return this.favPlayerService.buildFavPlayerResponse(favPlayerRequest);}
}
