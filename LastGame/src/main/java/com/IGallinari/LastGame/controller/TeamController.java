package com.IGallinari.LastGame.controller;

import com.IGallinari.LastGame.payload.request.TokenRequest;
import com.IGallinari.LastGame.payload.response.listTeam.TeamsResponse;
import com.IGallinari.LastGame.payload.response.standings.StandingsResponse;
import com.IGallinari.LastGame.payload.response.teamDetails.TeamDetailsResponse;
import com.IGallinari.LastGame.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for handling team-related operations.
 * This class is annotated with {@code @RestController} to indicate that it is a controller providing RESTful services.
 * The base mapping for the endpoints is set using {@code @RequestMapping("/team")}.
 * Cross-origin requests are allowed through the {@code @CrossOrigin} annotation.
 */
@RestController
@RequestMapping("/team")
@CrossOrigin
public class TeamController {

    /**
     * Autowired field for injecting the TeamService dependency.
     */
    @Autowired
    private TeamService service;

    /**
     * Endpoint for retrieving information about teams.
     *
     * @param tokenRequest The request object containing the user's authentication token.
     * @return The TeamsResponse containing information about teams or an error response.
     */
    @PostMapping("/getTeams")
    public TeamsResponse getTeams(@RequestBody TokenRequest tokenRequest) {
        return this.service.buildTeams(tokenRequest);
    }

    /**
     * Endpoint for retrieving details about a specific team.
     *
     * @param tokenRequest The request object containing the user's authentication token.
     * @param idTeam       The identifier of the team for which details are requested.
     * @param season       The season for which team details are requested.
     * @return The TeamDetailsResponse containing details about a specific team or an error response.
     */
    @PostMapping("/getTeamsDetails")
    public TeamDetailsResponse getTeamDetails(@RequestBody TokenRequest tokenRequest, @RequestParam int idTeam, @RequestParam int season) {
        return this.service.buildTeamDetailsResponse(tokenRequest, idTeam, season);
    }

    /**
     * Endpoint for comparing two teams.
     *
     * @param tokenRequest The request object containing the user's authentication token.
     * @param idTeam1      The identifier of the first team for comparison.
     * @param idTeam2      The identifier of the second team for comparison.
     * @param season       The season for which teams are compared.
     * @return The ResponseEntity containing the comparison result or an error response.
     */
    @PostMapping("/getCompareTeams")
    public ResponseEntity<?> getCompareTeam(@RequestBody TokenRequest tokenRequest, @RequestParam int idTeam1, @RequestParam int idTeam2, @RequestParam int season) {
        return this.service.buildCompareTeamResponse(tokenRequest, idTeam1, idTeam2, season);
    }

    /**
     * Endpoint for retrieving standings information.
     *
     * @param tokenRequest The request object containing the user's authentication token.
     * @param season       The season for which standings information is requested.
     * @return The StandingsResponse containing standings information or an error response.
     */
    @PostMapping("/getStandings")
    public StandingsResponse getStandings(@RequestBody TokenRequest tokenRequest, @RequestParam int season) {
        return this.service.buildStandingsResponse(tokenRequest, season);
    }
}
