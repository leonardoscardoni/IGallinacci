package com.IGallinari.LastGame.service;

import com.IGallinari.LastGame.entity.Player;
import com.IGallinari.LastGame.entity.PlayerTeam;
import com.IGallinari.LastGame.entity.StatsTeam;
import com.IGallinari.LastGame.entity.Team;
import com.IGallinari.LastGame.payload.response.comparison.team.CompareTeamResponse;
import com.IGallinari.LastGame.payload.response.comparison.team.ViewTeamCompareTeam;
import com.IGallinari.LastGame.payload.response.comparison.team.ViewTeamComparisonNbaAvgCompareTeam;
import com.IGallinari.LastGame.payload.response.listTeam.*;
import com.IGallinari.LastGame.payload.response.teamDetails.*;
import com.IGallinari.LastGame.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;
    private final StatsTeamRepository statsTeamRepository;

    private final PlayerTeamRepository playerTeamRepository;

    private final StatsGameRepository statsGameRepository;

    private final StatsPlayerRepository statsPlayerRepository;

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
        StatsTeam statsTeam = statsTeamRepository.findByTeamAndSeason(team, season);
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
                statsTeam.getFtp(),
                statsTeam.getTpm(),
                statsTeam.getTpa(),
                statsTeam.getTpp()
        );
        List<ViewPlayerTeamDetails> players= new ArrayList<>();
        List<PlayerTeam> playersTeam= playerTeamRepository.findByTeamAndSeason(team,season);
        for (PlayerTeam playerTeam: playersTeam){
            Player player = playerTeam.getPlayer();
            List<Float[]> avgStats = statsPlayerRepository.findAvgStatsByIdPlayer(player.getId());
            players.add(
                    new ViewPlayerTeamDetails(
                            player.getFirstname(),
                            player.getLastname(),
                            player.getJersey(),
                            Player.getRole(player.getPos()),
                            new ViewStatsPlayerTeamDetails(
                                    avgStats.get(0)[0],
                                    avgStats.get(0)[1],
                                    avgStats.get(0)[2],
                                    avgStats.get(0)[3],
                                    avgStats.get(0)[4]
                            )
                    )
            );
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
        List<ViewPlayerComparisonNbaAvgTeamDetails> playerComparisonNbaAvg= new ArrayList<>();
        List<String > dataNames= List.of("points","rebounds","assist","fieldShotsMade","freeTrowMade","treePointsMade");
        List<Integer[]> datasTeam= statsTeamRepository.findDataTeamByIdTeamAndSeason(idTeam,season);
        List<Float[]> datasNba = statsTeamRepository.findDataAvgNba(idTeam,season);
        for(int i=0;i<dataNames.size();i++){
            playerComparisonNbaAvg.add(
                    new ViewPlayerComparisonNbaAvgTeamDetails(
                    dataNames.get(i),
                    datasTeam.get(0)[i],
                    datasNba.get(0)[i]
                    )
            );
        }
        TeamDetailsResponse teamDetailsResponse = new TeamDetailsResponse(
                team.getId(),
                false,//DA IMPLEMENTARE QUANDO AVRO I PREFERITI
                team.getName(),
                team.getConference(),
                team.getDivision(),
                team.getLogo(),
                statsTeam.getRankConference(),
                statsTeam.getRankDivision(),
                viewStatsTeamDetails,
                players,
                viewShotTeamDetails,
                viewAssistReboundsTeamDetails,
                viewPointsTeamDetails,
                viewFoulsBallsBlocksTeamDetails,
                viewWinLossTeamDetails,
                playerComparisonNbaAvg
        );
        return teamDetailsResponse;
    }

    public CompareTeamResponse buildCompareTeamResponse(int idTeam1, int idTeam2, int season){
        Team team1 = teamRepository.findById(idTeam1);
        Team team2 = teamRepository.findById(idTeam2);
        StatsTeam statsTeam1= statsTeamRepository.findByTeamAndSeason(team1,season);
        StatsTeam statsTeam2 = statsTeamRepository.findByTeamAndSeason(team2,season);
        ViewTeamCompareTeam viewTeamCompareTeam1 = new ViewTeamCompareTeam(
                team1.getName(),
                team1.getLogo(),
                team1.getConference(),
                statsTeam1.getRankConference()
        );
        ViewTeamCompareTeam viewTeamCompareTeam2 = new ViewTeamCompareTeam(
                team2.getName(),
                team2.getLogo(),
                team1.getConference(),
                statsTeam2.getRankConference()
        );
        // Team data comparison
        List<ViewTeamComparisonNbaAvgCompareTeam> TeamCompareNba= new ArrayList<>();
        List<String > dataNames = List.of("points","rebounds","assist","fieldShotsMade","freeTrowMade","treePointsMade");
        List<Integer[]> datasTeam1 = statsTeamRepository.findDataTeamByIdTeamAndSeason(idTeam1,season);
        List<Integer[]> datasTeam2 = statsTeamRepository.findDataTeamByIdTeamAndSeason(idTeam2,season);
        for(int i=0;i<dataNames.size();i++){
            TeamCompareNba.add(
                    new ViewTeamComparisonNbaAvgCompareTeam(
                            dataNames.get(i),
                            datasTeam1.get(0)[i],
                            datasTeam2.get(0)[i]
                    )
            );
        }

        CompareTeamResponse CompareTeamResponse = new CompareTeamResponse(
                viewTeamCompareTeam1,
                viewTeamCompareTeam2,
                TeamCompareNba
        );
        return CompareTeamResponse;
    }
}
