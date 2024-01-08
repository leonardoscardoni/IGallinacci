package com.IGallinari.LastGame.service;

import com.IGallinari.LastGame.entity.Player;
import com.IGallinari.LastGame.entity.PlayerTeam;
import com.IGallinari.LastGame.entity.StatsTeam;
import com.IGallinari.LastGame.entity.Team;
import com.IGallinari.LastGame.payload.response.ListTeam.*;
import com.IGallinari.LastGame.payload.response.TeamDetails.*;
import com.IGallinari.LastGame.repository.PlayerTeamRepository;
import com.IGallinari.LastGame.repository.StatsGameRepository;
import com.IGallinari.LastGame.repository.StatsTeamRepository;
import com.IGallinari.LastGame.repository.TeamRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final StatsTeamRepository statsTeamRepository;

    private final TeamRepository teamRepository;

    private final PlayerTeamRepository playerTeamRepository;

    private final StatsGameRepository statsGameRepository;

    public Team getTeamById(int inputId){
        return teamRepository.findById(inputId);
    }

    public TeamsResponse buildTeams(){
        ViewConferenceEast conferenceEast = new ViewConferenceEast(
                buildViewDivision("Atlantic"),
                buildViewDivision("Central"),
                buildViewDivision("Southeast")
        );
        ViewConferenceWest conferenceWest = new ViewConferenceWest(
                buildViewDivision("Northwest"),
                buildViewDivision("Pacific"),
                buildViewDivision("Southwest")
        );
        return new TeamsResponse(conferenceWest, conferenceEast);
    }

    public TeamsNoConferenceResponse buildTeamsNoConferece(){
        TeamsNoConferenceResponse teamsNoConferenceResponse = new TeamsNoConferenceResponse(
                buildViewDivision("Atlantic"),
                buildViewDivision("Central"),
                buildViewDivision("Northwest"),
                buildViewDivision("Pacific"),
                buildViewDivision("Southeast"),
                buildViewDivision("Southwest")
        );
        return teamsNoConferenceResponse;
    }

    public ViewDivision buildViewDivision(String division){
        List<Team> teamsByDivision= teamRepository.findByDivision(division);
        List<ViewTeam> listViewTeams= new ArrayList<>();
        for (Team team: teamsByDivision){
            listViewTeams.add(
                    new ViewTeam(
                            team.getId(),
                            team.getNickname(),
                            team.getName(),
                            team.getLogo(),
                            false//DA IMPLEMENTARE QUANDO AVRO I PREFERITI
                    )
            );
        }
        return new ViewDivision(listViewTeams);
    }

    public TeamDetailsResponse buildTeamDetailsResponse(int idTeam, int season){
        Team team = teamRepository.findById(idTeam);
        StatsTeam statsTeam = statsTeamRepository.findByTeamAndSeason(team,season);
        ViewStatsTeamDetails viewStatsTeamDetails = new ViewStatsTeamDetails(
                statsTeam.getGames(),
                statsTeam.getPoints(),
                statsTeam.getFtp(),
                statsTeam.getTpp()
        );
        ViewShotTeamDetails viewShotTeamDetails = new ViewShotTeamDetails(
                statsTeam.getFgm(),
                statsTeam.getFga(),
                statsTeam.getFgp(),
                statsTeam.getFtm(),
                statsTeam.getFta(),
                statsTeam.getTpm(),
                statsTeam.getTpa(),
                statsTeam.getTpp()
        );
        List<ViewPlayerTeamDetails> players= new ArrayList<>();
        List<PlayerTeam> playersTeam= playerTeamRepository.findByTeamAndSeason(team,season);
        for (PlayerTeam playerTeam: playersTeam){
            Player player = playerTeam.getPlayer();
            players.add(
                    new ViewPlayerTeamDetails(
                            player.getFirstname(),
                            player.getLastname(),
                            player.getJersey(),
                            player.getPos(),
                            new ViewStatsPlayerTeamDetails()//da implementare
                    );
            )
        }
        ViewAssistReboundsTeamDetails viewAssistReboundsTeamDetails = new ViewAssistReboundsTeamDetails(
                statsTeam.getOffReb(),
                statsTeam.getDefReb(),
                statsTeam.getTotReb(),
                statsTeam.getAssists()
        );
        Integer allowedPoints= statsGameRepository.findAllowedPoints(team.getId());
        Integer pointsPerGame= statsGameRepository.findPointsPerGame(team.getId());
        ViewPointsTeamDetails viewPointsTeamDetails = new ViewPointsTeamDetails(
                statsTeam.getPoints(),
                pointsPerGame,
                allowedPoints
        );
        ViewFoulsBallsBlocksTeamDetails viewFoulsBallsBlocksTeamDetails = new ViewFoulsBallsBlocksTeamDetails(
                statsTeam.getPFouls(),
                statsTeam.getSteals(),
                statsTeam.getTurnovers(),
                statsTeam.getBlocks()
        );
        ViewWinLossTeamDetails viewWinLossTeamDetails = new ViewWinLossTeamDetails(
                statsTeam.getWinHome(),
                statsTeam.getLossHome()
        );
        TeamDetailsResponse teamDetailsResponse = new TeamDetailsResponse(
                team.getName(),
                team.getConference(),
                team.getDivision(),
                statsTeam.getRankConference(),
                statsTeam.getRankDivision(),
                viewStatsTeamDetails,
                players,
                viewShotTeamDetails,
                viewAssistReboundsTeamDetails
        )
        return teamDetailsResponse;
    }
}
