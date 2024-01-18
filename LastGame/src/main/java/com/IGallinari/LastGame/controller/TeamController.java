package com.IGallinari.LastGame.controller;

import com.IGallinari.LastGame.payload.request.TokenRequest;
import com.IGallinari.LastGame.payload.response.comparison.team.CompareTeamResponse;
import com.IGallinari.LastGame.payload.response.listTeam.TeamsResponse;
import com.IGallinari.LastGame.payload.response.ranking.RankingResponse;
import com.IGallinari.LastGame.payload.response.teamDetails.TeamDetailsResponse;
import com.IGallinari.LastGame.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
@CrossOrigin
public class TeamController {

    @Autowired
    private TeamService service;

    @PostMapping("/getTeams")
    public TeamsResponse getTeams(@RequestBody TokenRequest tokenRequest){return this.service.buildTeams(tokenRequest);}
    @PostMapping("/getTeamsDetails")
    public TeamDetailsResponse getTeamDetails(@RequestBody TokenRequest tokenRequest,@RequestParam int idTeam,@RequestParam int season){return this.service.buildTeamDetailsResponse(tokenRequest,idTeam,season);}
    @RequestMapping("/getCompareTeam")
    public CompareTeamResponse getCompareTeam(@RequestParam int idTeam1, @RequestParam int idTeam2, @RequestParam int season){return  this.service.buildCompareTeamResponse(idTeam1,idTeam2,season);}
    @RequestMapping("/getRanking")
    public RankingResponse getRankingResponse(@RequestParam int season){return this.service.buildRankingResponse(season);}
}
