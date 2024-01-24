package com.IGallinari.LastGame.controller;

import com.IGallinari.LastGame.payload.request.TokenRequest;
import com.IGallinari.LastGame.payload.response.playerDetails.PlayerDetailsResponse;
import com.IGallinari.LastGame.payload.response.listPlayerFilter.PlayerFilterResponse;
import com.IGallinari.LastGame.payload.response.playerDetailsByGame.PlayerDetailsByGameResponse;
import com.IGallinari.LastGame.payload.response.playerTeamFilter.PlayerTeamFilterResponse;
import com.IGallinari.LastGame.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for handling player-related operations.
 * This class is annotated with {@code @RestController} to indicate that it is a controller providing RESTful services.
 * The base mapping for the endpoints is set using {@code @RequestMapping("/player")}.
 * Cross-origin requests are allowed through the {@code @CrossOrigin} annotation.
 */
@RestController
@RequestMapping("/player")
@CrossOrigin
public class PlayerController {

    /**
     * Autowired field for injecting the PlayerService dependency.
     */
    @Autowired
    private PlayerService service;

    /**
     * Endpoint for retrieving players filtered by team and season.
     *
     * @param tokenRequest The request object containing the user's authentication token.
     * @param idTeam       The identifier of the team for which players are filtered.
     * @param season       The season for which players are filtered.
     * @return The PlayerTeamFilterResponse containing information about players filtered by team and season.
     */
    @PostMapping("/getPlayerFilteredByTeam")
    public PlayerTeamFilterResponse getPlayerTeamFilter(@RequestBody TokenRequest tokenRequest, @RequestParam int idTeam, @RequestParam int season) {
        return this.service.buildPlayerTeamFilterResponse(tokenRequest, idTeam, season);
    }

    /**
     * Endpoint for retrieving player details by game.
     *
     * @param tokenRequest The request object containing the user's authentication token.
     * @param idGame       The identifier of the game for which player details are requested.
     * @param idPlayer     The identifier of the player for which details are requested.
     * @return The PlayerDetailsByGameResponse containing details about a player for a specific game.
     */
    @PostMapping("/getPlayerDetailsByGame")
    public PlayerDetailsByGameResponse getPlayerDetailsByGame(@RequestBody TokenRequest tokenRequest, @RequestParam int idGame, @RequestParam int idPlayer) {
        return this.service.buildPlayerDetailsByGameResponse(tokenRequest, idGame, idPlayer);
    }

    /**
     * Endpoint for retrieving team roles for player filtering.
     *
     * @return The PlayerFilterResponse containing information about team roles for player filtering.
     */
    @RequestMapping("/getTeamRolesPlayerFilter")
    public PlayerFilterResponse getTeamRolesPlayerFilter() {
        return this.service.buildCompareFilterResponse();
    }

    /**
     * Endpoint for retrieving player details independently by game.
     *
     * @param tokenRequest The request object containing the user's authentication token.
     * @param idPlayer     The identifier of the player for which details are requested.
     * @param season       The season for which player details are requested.
     * @return The PlayerDetailsResponse containing details about a player independently by game.
     */
    @PostMapping("/getPlayerDetails")
    public PlayerDetailsResponse getPlayerDetails(@RequestBody TokenRequest tokenRequest, @RequestParam int idPlayer, @RequestParam int season) {
        return this.service.buildDetailsPlayerIndependentByGameResponse(tokenRequest, idPlayer, season);
    }

    /**
     * Endpoint for comparing two players.
     *
     * @param tokenRequest The request object containing the user's authentication token.
     * @param idPlayer1    The identifier of the first player for comparison.
     * @param idPlayer2    The identifier of the second player for comparison.
     * @param season       The season for which players are compared.
     * @return The ResponseEntity containing the comparison result or an error response.
     */
    @PostMapping("/getComparePlayer")
    public ResponseEntity<?> getComparePlayer(@RequestBody TokenRequest tokenRequest, @RequestParam int idPlayer1, @RequestParam int idPlayer2, @RequestParam int season) {
        return this.service.buildComparePlayersResponse(tokenRequest, idPlayer1, idPlayer2, season);
    }
}
