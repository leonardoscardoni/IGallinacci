package com.IGallinari.LastGame.service;

import com.IGallinari.LastGame.entity.*;
import com.IGallinari.LastGame.payload.request.TokenRequest;
import com.IGallinari.LastGame.payload.response.NeedToBeLoggedResponse;
import com.IGallinari.LastGame.payload.response.lastFourGames.ViewLastFourGames;
import com.IGallinari.LastGame.payload.response.lastFourGames.ViewLastGame;
import com.IGallinari.LastGame.payload.response.lastFourHtH.HeadToHead;
import com.IGallinari.LastGame.payload.response.lastFourHtH.LastFourHtH;
import com.IGallinari.LastGame.payload.response.listTeam.*;
import com.IGallinari.LastGame.payload.response.standings.StandingsResponse;
import com.IGallinari.LastGame.payload.response.standings.ViewTeamStanding;
import com.IGallinari.LastGame.payload.response.teamDetails.*;
import com.IGallinari.LastGame.payload.response.comparison.team.CompareTeamsResponse;
import com.IGallinari.LastGame.payload.response.comparison.team.ViewTeamCompareTeam;
import com.IGallinari.LastGame.payload.response.comparison.team.ViewTeamComparisonNbaAvgCompareTeam;
import com.IGallinari.LastGame.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    private final StatsTeamRepository statsTeamRepository;

    private final PlayerTeamRepository playerTeamRepository;

    private final StatsGameRepository statsGameRepository;

    private final StatsPlayerRepository statsPlayerRepository;

    private final GameRepository gameRepository;

    private final FavTeamRepository favTeamRepository;

    private final JwtService jwtService;

    public Team getTeamById(int inputId){
        return teamRepository.findById(inputId);
    }

    public TeamsResponse buildTeams(TokenRequest tokenRequest){
        String token = tokenRequest.getToken();
        boolean logged= jwtService.isTokenValid(token);
        Integer idUser= null;
        if(logged){
            idUser = jwtService.getIdUser(token);
        }
        ViewConferenceEast conferenceEast = new ViewConferenceEast(
                buildViewDivision("Atlantic",idUser),
                buildViewDivision("Central",idUser),
                buildViewDivision("Southeast",idUser)
        );
        ViewConferenceWest conferenceWest = new ViewConferenceWest(
                buildViewDivision("Northwest",idUser),
                buildViewDivision("Pacific",idUser),
                buildViewDivision("Southwest",idUser)
        );
        return new TeamsResponse(logged, conferenceWest, conferenceEast);
    }

    public ViewDivision buildViewDivision(String division, Integer idUser){
        List<Team> teamsByDivision= teamRepository.findByDivision(division);
        List<ViewTeam> listViewTeams= new ArrayList<>();
        for (Team team: teamsByDivision){
            boolean favourite= idUser != null && favTeamRepository.existsByIdUserAndIdTeam(idUser, team.getId()) ==1;
            listViewTeams.add(
                    new ViewTeam(
                            team.getId(),
                            team.getNickname(),
                            team.getName(),
                            team.getLogo(),
                            favourite
                    )
            );
        }
        return new ViewDivision(listViewTeams);
    }

    public TeamDetailsResponse buildTeamDetailsResponse(TokenRequest tokenRequest, int idTeam, int season){
        String token = tokenRequest.getToken();
        boolean logged= jwtService.isTokenValid(token);
        boolean favourite= false;
        if(logged){
            int idUser = jwtService.getIdUser(token);
            favourite= favTeamRepository.existsByIdUserAndIdTeam(idUser, idTeam) ==1;
        }
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
                            player.getId(),
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
        Float allowedPoints= statsGameRepository.findAllowedPoints(team.getId(),season);
        Float pointsPerGame= statsGameRepository.findPointsPerGame(team.getId(),season);
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
                logged,
                team.getId(),
                favourite,
                team.getName(),
                team.getLogo(),
                team.getConference(),
                team.getDivision(),
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
    public List<ViewLastGame> buildListViewLastGame(Team team, LocalDate date){
        List<ViewLastGame> lastGames = new ArrayList<>();
        List<Game> games= gameRepository.findLastFourGameByTeam(team.getId(),date);
        Team otherTeam = new Team();
        for (Game game: games){
            if(team.equals(game.getHomeTeam())) {
                otherTeam = game.getVisitorTeam();
            }else{
                otherTeam = game.getHomeTeam();
            }
            StatsGame statsGameTeam = statsGameRepository.findStatsGameByGameAndTeam(game,team);
            StatsGame statsGameOtherTeam = statsGameRepository.findStatsGameByGameAndTeam(game,otherTeam);
            Boolean result = null;
            if(statsGameTeam.getPoints()>statsGameOtherTeam.getPoints()) {
                result = Boolean.TRUE;
            }else{
                result = Boolean.FALSE;
            }
            lastGames.add(
                    new ViewLastGame(
                            game.getId(),
                            result
                    )
            );
        }
        return lastGames;
    }
    public List<HeadToHead> builListHeadToHead(Team teamHome, Team teamVisitor, LocalDate date){
        List<HeadToHead> listHeadToHead = new ArrayList<>();
        List<Game> games = gameRepository.findLastFourHtH(teamHome.getId(),teamVisitor.getId(),date);
        for (Game game : games){
            StatsGame statsGame = statsGameRepository.findStatsGameByGameAndTeam(game,teamHome);
            listHeadToHead.add(
                    new HeadToHead(
                            game.getId(),
                            statsGame.getPoints()
                    )
            );
        }
        for (Game game : games){
            StatsGame statsGame = statsGameRepository.findStatsGameByGameAndTeam(game,teamVisitor);
            listHeadToHead.add(
                    new HeadToHead(
                            game.getId(),
                            statsGame.getPoints()
                    )
            );
        }
        return listHeadToHead;
    }

    public ResponseEntity<?> buildCompareTeamResponse(TokenRequest tokenRequest, int idTeam1, int idTeam2, int season){
        String token = tokenRequest.getToken();
        boolean logged= jwtService.isTokenValid(token);
        if(!logged){
            return ResponseEntity.ok(new NeedToBeLoggedResponse());
        }
        int idUser = jwtService.getIdUser(token);
        Team team1 = teamRepository.findById(idTeam1);
        Team team2 = teamRepository.findById(idTeam2);
        StatsTeam statsTeam1= statsTeamRepository.findByTeamAndSeason(team1, season);
        StatsTeam statsTeam2 = statsTeamRepository.findByTeamAndSeason(team2, season);
        boolean favouriteTeam1= favTeamRepository.existsByIdUserAndIdTeam(idUser, idTeam1) ==1;
        boolean favouriteTeam2= favTeamRepository.existsByIdUserAndIdTeam(idUser, idTeam2) ==1;
        ViewTeamCompareTeam viewTeamCompareTeam1 = new ViewTeamCompareTeam(
                favouriteTeam1,
                team1.getId(),
                team1.getName(),
                team1.getCode(),
                team1.getLogo(),
                team1.getConference(),
                statsTeam1.getRankConference()
        );
        ViewTeamCompareTeam viewTeamCompareTeam2 = new ViewTeamCompareTeam(
                favouriteTeam2,
                team2.getId(),
                team2.getName(),
                team2.getCode(),
                team2.getLogo(),
                team1.getConference(),
                statsTeam2.getRankConference()
        );
        List<ViewTeamComparisonNbaAvgCompareTeam> TeamCompareNba= new ArrayList<>();
        List<String > dataNames = List.of("points","rebounds","assist","fieldShotsMade","freeTrowMade","treePointsMade");
        List<Integer[]> dataTeam1 = statsTeamRepository.findDataTeamByIdTeamAndSeason(idTeam1,season);
        List<Integer[]> dataTeam2 = statsTeamRepository.findDataTeamByIdTeamAndSeason(idTeam2,season);
        LocalDate today = LocalDate.now();
        for(int i=0;i<dataNames.size();i++){
            TeamCompareNba.add(
                    new ViewTeamComparisonNbaAvgCompareTeam(
                            dataNames.get(i),
                            dataTeam1.get(0)[i],
                            dataTeam2.get(0)[i]
                    )
            );
        }
        ViewLastFourGames viewLastFourGamesTeam1 = new ViewLastFourGames(
                team1.getId(),
                team1.getName(),
                team1.getLogo(),
                buildListViewLastGame(team1,today));
        ViewLastFourGames viewLastFourGamesTeam2 = new ViewLastFourGames(
                team2.getId(),
                team2.getName(),
                team2.getLogo(),
                buildListViewLastGame(team2,today)
        );
        List<HeadToHead> headToHeadList = builListHeadToHead(team1, team2, today);
        LastFourHtH lastFourHtHTeam1 = new LastFourHtH(
                team1.getId(),
                team1.getCode(),
                team1.getLogo(),
                headToHeadList.subList(0, Math.min(4, headToHeadList.size()))
        );
        LastFourHtH lastFourHtHTeam2 = new LastFourHtH(
                team2.getId(),
                team2.getCode(),
                team2.getLogo(),
                headToHeadList.subList(Math.max(0, headToHeadList.size() - 4), headToHeadList.size())
        );
        CompareTeamsResponse CompareTeamsResponse = new CompareTeamsResponse(
                viewTeamCompareTeam1,
                viewTeamCompareTeam2,
                TeamCompareNba,
                viewLastFourGamesTeam1,
                viewLastFourGamesTeam2,
                lastFourHtHTeam1,
                lastFourHtHTeam2
        );
        return ResponseEntity.ok(CompareTeamsResponse);
    }

    public StandingsResponse buildStandingsResponse(TokenRequest tokenRequest, int season) {
        List<ViewTeamStanding> eastTeamsRanking = new ArrayList<>();
        List<ViewTeamStanding> westTeamsRanking = new ArrayList<>();
        List<Team> eastTeams = teamRepository.findByConference("East");
        List<Team> westTeams = teamRepository.findByConference("West");
        String token = tokenRequest.getToken();
        boolean logged= jwtService.isTokenValid(token);

        for (Team team : eastTeams) {
            StatsTeam statsTeam = statsTeamRepository.findByTeamAndSeason(team, season);
            Float avgPointsPerGame = statsGameRepository.findPointsPerGame(team.getId(), season);
            Float avgPointsAllowedPerGame = statsGameRepository.findAllowedPoints(team.getId(), season);
            boolean favourite = false;
            if(logged){
                favourite = favTeamRepository.existsByIdUserAndIdTeam(jwtService.getIdUser(token), team.getId())==1;
            }
            eastTeamsRanking.add(
                    new ViewTeamStanding(
                            favourite,
                            statsTeam.getRankConference(),
                            team.getId(),
                            team.getLogo(),
                            team.getNickname(),
                            statsTeam.getWinConference(),
                            statsTeam.getLossConference(),
                            statsTeam.getWinHome(),
                            statsTeam.getWinAway(),
                            avgPointsPerGame,
                            avgPointsAllowedPerGame,
                            statsTeam.getStreak()

                    )
            );
        }

        for (Team team : westTeams) {
            StatsTeam statsTeam = statsTeamRepository.findByTeamAndSeason(team, season);
            Float avgPointsPerGame = statsGameRepository.findPointsPerGame(team.getId(), season);
            Float avgPointsAllowedPerGame = statsGameRepository.findAllowedPoints(team.getId(), season);
            boolean favourite = false;
            if(logged){
                favourite = favTeamRepository.existsByIdUserAndIdTeam(jwtService.getIdUser(token), team.getId())==1;
            }
            westTeamsRanking.add(
                    new ViewTeamStanding(
                            favourite,
                            statsTeam.getRankConference(),
                            team.getId(),
                            team.getLogo(),
                            team.getNickname(),
                            statsTeam.getWinConference(),
                            statsTeam.getLossConference(),
                            statsTeam.getWinHome(),
                            statsTeam.getWinAway(),
                            avgPointsPerGame,
                            avgPointsAllowedPerGame,
                            statsTeam.getStreak()
                    )
            );
        }
        eastTeamsRanking.sort(Comparator.comparing(ViewTeamStanding::getRank));
        westTeamsRanking.sort(Comparator.comparing(ViewTeamStanding::getRank));
        return new StandingsResponse(logged,eastTeamsRanking, westTeamsRanking);
    }


}

