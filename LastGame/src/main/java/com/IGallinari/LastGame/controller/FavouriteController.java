package com.IGallinari.LastGame.controller;

import com.IGallinari.LastGame.payload.request.favourite.player.FavPlayerRequest;
import com.IGallinari.LastGame.payload.request.favourite.team.FavTeamRequest;
import com.IGallinari.LastGame.service.FavPlayerService;
import com.IGallinari.LastGame.service.FavTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for handling favorite-related operations.
 * This class is annotated with {@code @RestController} to indicate that it is a controller providing RESTful services.
 * The base mapping for the endpoints is set using {@code @RequestMapping("/favourite")}.
 * Cross-origin requests are allowed through the {@code @CrossOrigin} annotation.
 */
@RestController
@RequestMapping("/favourite")
@CrossOrigin
public class FavouriteController {

    /**
     * Autowired field for injecting the FavTeamService dependency.
     */
    @Autowired
    private FavTeamService favTeamService;

    /**
     * Autowired field for injecting the FavPlayerService dependency.
     */
    @Autowired
    private FavPlayerService favPlayerService;

    /**
     * Endpoint for managing favorite teams.
     *
     * @param favTeamRequest The request object containing information for managing favorite teams.
     * @return The ResponseEntity containing a response related to favorite teams or an error response.
     */
    @PostMapping("/team")
    public ResponseEntity<?> favTeam(@RequestBody FavTeamRequest favTeamRequest) {
        return this.favTeamService.buildFavTeamResponse(favTeamRequest);
    }

    /**
     * Endpoint for managing favorite players.
     *
     * @param favPlayerRequest The request object containing information for managing favorite players.
     * @return The ResponseEntity containing a response related to favorite players or an error response.
     */
    @PostMapping("/player")
    public ResponseEntity<?> favPlayer(@RequestBody FavPlayerRequest favPlayerRequest) {
        return this.favPlayerService.buildFavPlayerResponse(favPlayerRequest);
    }
}
