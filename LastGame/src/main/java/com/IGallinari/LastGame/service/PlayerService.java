package com.IGallinari.LastGame.service;


import java.util.ArrayList;
import java.util.List;


import com.IGallinari.LastGame.payload.response.DetailsPlayerIndependByGame.*;
import com.IGallinari.LastGame.payload.response.ListPlayerFilter.PlayerFilterResponse;
import com.IGallinari.LastGame.payload.response.ListPlayerFilter.ViewRolesPlayerFilter;
import com.IGallinari.LastGame.payload.response.ListPlayerFilter.ViewTeamsPlayerFilter;
import org.springframework.stereotype.Service;

import com.IGallinari.LastGame.entity.Player;
import com.IGallinari.LastGame.entity.PlayerTeam;
import com.IGallinari.LastGame.entity.Team;
import com.IGallinari.LastGame.payload.response.PlayerTeamFilter.PlayerTeamFilterResponse;
import com.IGallinari.LastGame.payload.response.PlayerTeamFilter.ViewPlayersPlayerTeamFilter;
import com.IGallinari.LastGame.repository.PlayerRepository;
import com.IGallinari.LastGame.repository.PlayerTeamRepository;
import com.IGallinari.LastGame.repository.TeamRepository;

import lombok.RequiredArgsConstructor;
import com.IGallinari.LastGame.entity.*;
import com.IGallinari.LastGame.payload.response.PlayerDetailsByGame.*;
import com.IGallinari.LastGame.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;
    private final PlayerTeamRepository playerTeamRepository;
    private final GameRepository gameRepository;
    private final StatsPlayerRepository statsPlayerRepository;
    private final StatsGameRepository statsGameRepository;

    public PlayerTeamFilterResponse buildPlayerTeamFilterResponse(int idTeam, int season){
        Team team = teamRepository.findById(idTeam);
        List<ViewPlayersPlayerTeamFilter> players = new ArrayList<>();
        List<PlayerTeam> playersTeam = playerTeamRepository.findByTeamAndSeason(team, season);
        for (PlayerTeam playerTeam: playersTeam){
            Player player = playerTeam.getPlayer();
            players.add(
                    new ViewPlayersPlayerTeamFilter(
                        player.getId(),
                        player.getFirstname() +" "+ player.getLastname(),
                        Player.getRole(player.getPos()),
                        player.getJersey(),
                        player.getCountry(),
                        false
                    )
            );
        }
        PlayerTeamFilterResponse playerTeamFilterResponse = new PlayerTeamFilterResponse(
            team.getId(),
            team.getNickname(),
            team.getName(),
            season,
            players
        );
        return playerTeamFilterResponse;
    }

    public PlayerDetailsByGameResponse buildPlayerDetailsByGameResponse (int idGame, int idPlayer){
        Game game = gameRepository.findById(idGame);
        Team teamHome = game.getHomeTeam();
        Team teamVisitor = game.getVisitorTeam();
        Player player = playerRepository.findById(idPlayer);
        StatsPlayer statsPlayer = statsPlayerRepository.findByPlayerAndGame(player,game);
        StatsGame statsGameHome = statsGameRepository.findStatsGameByGameAndTeam(game,teamHome);
        StatsGame statsGameVisitor = statsGameRepository.findStatsGameByGameAndTeam(game, teamVisitor);
        PlayerTeam playerTeam = playerTeamRepository.findByPlayerAndSeason(player,game.getSeason());
        Team teamOfPlayer= playerTeam.getTeam();
        Arena arena = game.getArena();
        ViewHeaderPlayerDetailsByGame viewHeaderPlayerDetailsByGame = new ViewHeaderPlayerDetailsByGame(
                arena.getName(),
                arena.getCity(),
                game.getDate(),
                game.getTime()
        );
        ViewTeamPlayerDetailsByGame viewHomeTeamPlayerDetailsByGame = new ViewTeamPlayerDetailsByGame(
                teamHome.getName(),
                teamHome.getLogo(),
                statsGameHome.getPoints()
        );
        ViewTeamPlayerDetailsByGame viewVisitorTeamPlayerDetailsByGame = new ViewTeamPlayerDetailsByGame(
                teamVisitor.getName(),
                teamVisitor.getLogo(),
                statsGameVisitor.getPoints()
        );
        ViewPlayerInfoPlayerDetailsByGame viewPlayerInfoPlayerDetailsByGame = new ViewPlayerInfoPlayerDetailsByGame(
                teamHome.getId(),
                player.getFirstname(),
                player.getLastname(),
                teamOfPlayer.getLogo(),
                player.getPos()

        );
        ViewStatsPlayerDetailsByGame viewStatsPlayerDetailsByGame = new ViewStatsPlayerDetailsByGame(
                statsPlayer.getMin(),
                statsPlayer.getPoints(),
                statsPlayer.getTotReb(),
                statsPlayer.getAssists()
        );
        ViewShotsPlayerDetailsByGame viewShotsPlayerDetailsByGame = new ViewShotsPlayerDetailsByGame(
                statsPlayer.getFgm(),
                statsPlayer.getFga(),
                statsPlayer.getFgp(),
                statsPlayer.getFtm(),
                statsPlayer.getFta(),
                statsPlayer.getFtp(),
                statsPlayer.getTpm(),
                statsPlayer.getTpa(),
                statsPlayer.getTpp()
        );
        ViewAssistReboundsPlayerDetailsByGame viewAssistReboundsPlayerDetailsByGame = new ViewAssistReboundsPlayerDetailsByGame(
                statsPlayer.getOffReb(),
                statsPlayer.getDefReb(),
                statsPlayer.getTotReb(),
                statsPlayer.getAssists()
        );
        ViewFoulsBallsBlocksPlayerDetailsByGame viewFoulsBallsBlocksPlayerDetailsByGame = new ViewFoulsBallsBlocksPlayerDetailsByGame(
                statsPlayer.getPFouls(),
                statsPlayer.getSteals(),
                statsPlayer.getTurnovers(),
                statsPlayer.getBlocks()
        );
        return new PlayerDetailsByGameResponse(game.getId(),
                viewHeaderPlayerDetailsByGame,viewHomeTeamPlayerDetailsByGame,
                viewVisitorTeamPlayerDetailsByGame,
                viewPlayerInfoPlayerDetailsByGame,
                viewStatsPlayerDetailsByGame,
                viewShotsPlayerDetailsByGame,
                viewAssistReboundsPlayerDetailsByGame,
                viewFoulsBallsBlocksPlayerDetailsByGame
        );
    }
        public PlayerFilterResponse buildCompareFilterResponse(){
            List<ViewTeamsPlayerFilter> allTeam = new ArrayList<>();
            List<Team> dataTeams = teamRepository.findAll();
            for (Team team: dataTeams
                 ) { allTeam.add(new ViewTeamsPlayerFilter(
                    team.getId(),
                    team.getName()
            ));
            }

            List<ViewRolesPlayerFilter> allRoles = new ArrayList<>();
            List<String> roles = playerRepository.findRoles();
            for (String role : roles
                 ) { allRoles.add(new ViewRolesPlayerFilter((Player.getRole(role))));
            }
            PlayerFilterResponse playerFilterResponse = new PlayerFilterResponse(allTeam, allRoles);
            return  playerFilterResponse;
        }

    public DetailsPlayerIndependentByGameResponse buildDetailsPlayerIndependentByGameResponse(int idGame, int idPlayer) {
        Game game = gameRepository.findById(idGame);
        Player player = playerRepository.findById(idPlayer);
        StatsPlayer statsPlayer = statsPlayerRepository.findByPlayerAndGame(player,game);
        PlayerTeam playerTeam = playerTeamRepository.findByPlayerAndSeason(player,game.getSeason());
        Team team= playerTeam.getTeam();
        boolean favourite = false;
        String firstName = player.getFirstname();
        String lastName = player.getLastname();
        int idTeam = team.getId();
        String logo = team.getLogo();
        String nameTeam = team.getName();

        Float avgPoints = statsPlayerRepository.findAvgPointsByIdPlayerAndSeason(idPlayer, game.getSeason());
        Float sumPoints = statsPlayerRepository.findSumPointsByIdPlayerAndSeason(idPlayer, game.getSeason());
        ViewGamesDetailsPlayerIndependentByGame viewGamesDetailsPlayerIndependentByGame = new ViewGamesDetailsPlayerIndependentByGame(
                game.getId(),
                player.getJersey(),
                avgPoints,
                sumPoints
        );
        ViewPlayerBioDetailsIndependentByGame viewPlayerBioDetailsIndependentByGame = new ViewPlayerBioDetailsIndependentByGame(
                player.getDateOfBirth(),
                player.getCountry(),
                player.getWeight(),
                player.getHeight(),
                player.getPos(),
                player.getStartYear(),
                player.getCollege(),
                player.getAffiliation()
        );
        ViewShotsDetailsPlayerIndependentByGame viewShotsDetailsPlayerIndependentByGame = new ViewShotsDetailsPlayerIndependentByGame(
                statsPlayer.getFgm(),
                statsPlayer.getFga(),
                statsPlayer.getFgp(),
                statsPlayer.getFtm(),
                statsPlayer.getFta(),
                statsPlayer.getFtp(),
                statsPlayer.getTpm(),
                statsPlayer.getTpa(),
                statsPlayer.getTpp()
        );
        ViewAssistReboundsDetailsPlayerIndependentByGame viewAssistReboundsDetailsPlayerIndependentByGame = new ViewAssistReboundsDetailsPlayerIndependentByGame(
                statsPlayer.getOffReb(),
                statsPlayer.getDefReb(),
                statsPlayer.getTotReb(),
                statsPlayer.getAssists()
        );
        ViewFoulsBallsBlocksDetailsPlayerIndependentByGame viewFoulsBallsBlocksDetailsPlayerIndependentByGame = new ViewFoulsBallsBlocksDetailsPlayerIndependentByGame(
                statsPlayer.getPFouls(),
                statsPlayer.getSteals(),
                statsPlayer.getTurnovers(),
                statsPlayer.getBlocks()
        );
        ViewPointsDetailsPlayerIndependentByGame viewPointsDetailsPlayerIndependentByGame = new ViewPointsDetailsPlayerIndependentByGame(
                statsPlayer.getPoints(),
                avgPoints
        );

        return new DetailsPlayerIndependentByGameResponse(
                favourite,
                idPlayer,
                firstName,
                lastName,
                idTeam,
                logo,
                nameTeam,
                viewGamesDetailsPlayerIndependentByGame,
                viewPlayerBioDetailsIndependentByGame,
                viewShotsDetailsPlayerIndependentByGame,
                viewAssistReboundsDetailsPlayerIndependentByGame,
                viewFoulsBallsBlocksDetailsPlayerIndependentByGame,
                viewPointsDetailsPlayerIndependentByGame
        );
    }}
