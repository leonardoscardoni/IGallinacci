package com.IGallinari.LastGame.controller;

import com.IGallinari.LastGame.payload.response.Home.HomeResponse;
import com.IGallinari.LastGame.payload.response.ListTeam.TeamsNoConferenceResponse;
import com.IGallinari.LastGame.payload.response.ListTeam.TeamsResponse;
import com.IGallinari.LastGame.payload.response.TeamDetails.TeamDetailsResponse;
import com.IGallinari.LastGame.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teams")
@CrossOrigin
public class TeamController {

    @Autowired
    private TeamService service;

    @RequestMapping("/getTeamsNoConference")
    public TeamsNoConferenceResponse getTeamsNoConference(){return this.service.buildTeamsNoConferece();}

    @RequestMapping("/getTeams")
    public TeamsResponse getTeams(){return this.service.buildTeams();}

    @RequestMapping("/getTeamsDetails")
    public TeamDetailsResponse getTeamDetails(@RequestParam int idTeam,@RequestParam int season){return this.service.buildTeamDetailsResponse(idTeam,season);}
}
