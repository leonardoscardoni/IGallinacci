package com.IGallinari.LastGame.service;


import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;


import com.IGallinari.LastGame.payload.response.playerDetails.*;
import com.IGallinari.LastGame.payload.response.comparison.player.ComparePlayerResponse;
import com.IGallinari.LastGame.payload.response.comparison.player.ViewDataPlayerComparePlayer;
import com.IGallinari.LastGame.payload.response.comparison.player.ViewHeaderComparePlayer;
import com.IGallinari.LastGame.payload.response.comparison.player.ViewPlayerComparePlayer;
import com.IGallinari.LastGame.payload.response.listPlayerFilter.PlayerFilterResponse;
import com.IGallinari.LastGame.payload.response.listPlayerFilter.ViewRolesPlayerFilter;
import com.IGallinari.LastGame.payload.response.listPlayerFilter.ViewTeamsPlayerFilter;
import com.IGallinari.LastGame.payload.response.playerDetailsByGame.*;
import com.IGallinari.LastGame.payload.response.playerTeamFilter.PlayerTeamFilterResponse;
import com.IGallinari.LastGame.payload.response.playerTeamFilter.ViewPlayersPlayerTeamFilter;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import com.IGallinari.LastGame.entity.*;
import com.IGallinari.LastGame.repository.*;


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
        return new PlayerTeamFilterResponse(
            team.getId(),
            team.getLogo(),
            team.getNickname(),
            team.getName(),
            season,
            players
        );
    }

    public PlayerDetailsByGameResponse buildPlayerDetailsByGameResponse (int idGame, int idPlayer){
        Game game = gameRepository.findById(idGame);
        Team teamHome = game.getHomeTeam();
        Team teamVisitor = game.getVisitorTeam();
        Player player = playerRepository.findById(idPlayer);
        StatsPlayer statsPlayer = statsPlayerRepository.findByPlayerAndGame(player,game);
        StatsGame statsGameHome = statsGameRepository.findStatsGameByGameAndTeam(game,teamHome);
        StatsGame statsGameVisitor = statsGameRepository.findStatsGameByGameAndTeam(game, teamVisitor);
        Team teamOfPlayer = teamRepository.findById((statsPlayerRepository.findidTeamByPlayerAndGame(idPlayer,idGame)).intValue());
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
                Player.getRole(player.getPos())

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

    public PlayerDetailsResponse buildDetailsPlayerIndependentByGameResponse(int idPlayer, int season) {
        Player player = playerRepository.findById(idPlayer);
        List<Object[]> sumStatsPlayerAndAvgPointsArray = statsPlayerRepository.findSumStatsPlayerAndAvgPointsByIdPlayerAndSeason(idPlayer, season);
        PlayerTeam playerTeam = playerTeamRepository.findByPlayerAndSeason(player,season);
        Team team= teamRepository.findById((int)statsPlayerRepository.findLastTeamPlayer(idPlayer,season));
        boolean favourite = false;
        String firstName = player.getFirstname();
        String lastName = player.getLastname();
        int idTeam = team.getId();
        String logo = team.getLogo();
        String nameTeam = team.getName();
        ViewGamePlayerDetails viewGamePlayerDetails = new ViewGamePlayerDetails(
                Integer.parseInt(sumStatsPlayerAndAvgPointsArray.get(0)[19].toString()),
                player.getJersey(),
                Float.parseFloat(sumStatsPlayerAndAvgPointsArray.get(0)[18].toString()),
                Integer.parseInt(sumStatsPlayerAndAvgPointsArray.get(0)[17].toString())
        );
        ViewPlayerBioPlayerDetails viewPlayerBioPlayerDetails = new ViewPlayerBioPlayerDetails(
                player.getDateOfBirth(),
                player.getCountry(),
                player.getWeight(),
                player.getHeight(),
                player.getPos(),
                player.getStartYear(),
                player.getCollege(),
                player.getAffiliation()
        );
        ViewShotsPlayerDetails viewShotsPlayerDetails = new ViewShotsPlayerDetails(
                Integer.parseInt(sumStatsPlayerAndAvgPointsArray.get(0)[0].toString()),
                Integer.parseInt(sumStatsPlayerAndAvgPointsArray.get(0)[1].toString()),
                Float.parseFloat(sumStatsPlayerAndAvgPointsArray.get(0)[2].toString()),
                Integer.parseInt(sumStatsPlayerAndAvgPointsArray.get(0)[3].toString()),
                Integer.parseInt(sumStatsPlayerAndAvgPointsArray.get(0)[4].toString()),
                Float.parseFloat(sumStatsPlayerAndAvgPointsArray.get(0)[5].toString()),
                Integer.parseInt(sumStatsPlayerAndAvgPointsArray.get(0)[6].toString()),
                Integer.parseInt(sumStatsPlayerAndAvgPointsArray.get(0)[7].toString()),
                Float.parseFloat(sumStatsPlayerAndAvgPointsArray.get(0)[8].toString())
        );
        ViewAssistReboundsPlayerDetails viewAssistReboundsPlayerDetails = new ViewAssistReboundsPlayerDetails(
                Integer.parseInt(sumStatsPlayerAndAvgPointsArray.get(0)[9].toString()),
                Integer.parseInt(sumStatsPlayerAndAvgPointsArray.get(0)[10].toString()),
                Integer.parseInt(sumStatsPlayerAndAvgPointsArray.get(0)[11].toString()),
                Integer.parseInt(sumStatsPlayerAndAvgPointsArray.get(0)[12].toString())
        );
        ViewFoulsBallsBlocksPlayerDetails viewFoulsBallsBlocksPlayerDetails = new ViewFoulsBallsBlocksPlayerDetails(
                Integer.parseInt(sumStatsPlayerAndAvgPointsArray.get(0)[13].toString()),
                Integer.parseInt(sumStatsPlayerAndAvgPointsArray.get(0)[14].toString()),
                Integer.parseInt(sumStatsPlayerAndAvgPointsArray.get(0)[15].toString()),
                Integer.parseInt(sumStatsPlayerAndAvgPointsArray.get(0)[16].toString())
        );
        ViewPointsPlayerDetails viewPointsPlayerDetails = new ViewPointsPlayerDetails(
                Integer.parseInt(sumStatsPlayerAndAvgPointsArray.get(0)[17].toString()),
                Float.parseFloat(sumStatsPlayerAndAvgPointsArray.get(0)[18].toString())
        );

        return new PlayerDetailsResponse(
                favourite,
                idPlayer,
                firstName,
                lastName,
                idTeam,
                logo,
                nameTeam,
                viewGamePlayerDetails,
                viewPlayerBioPlayerDetails,
                viewShotsPlayerDetails,
                viewAssistReboundsPlayerDetails,
                viewFoulsBallsBlocksPlayerDetails,
                viewPointsPlayerDetails
        );
    }

    public ComparePlayerResponse buildComparePlayerResponse(int idPlayer1, int idPlayer2, int season){
        Player player1 = playerRepository.findById(idPlayer1);
        Player player2 = playerRepository.findById(idPlayer2);
        Integer idteam1 = statsPlayerRepository.findLastTeamPlayer(idPlayer1, season);
        Integer idteam2 = statsPlayerRepository.findLastTeamPlayer(idPlayer1, season);
        Team team = teamRepository.findById((statsPlayerRepository.findLastTeamPlayer(idPlayer2, season)).intValue());
        Team team1 = teamRepository.findById(idteam1.intValue());
        Team team2 = teamRepository.findById(idteam2.intValue());


        ViewHeaderComparePlayer viewHeaderComparePlayer1 = new ViewHeaderComparePlayer(
                player1.getId(),
                player1.getFirstname()+" "+player1.getLastname(),
                team1.getLogo());
        ViewHeaderComparePlayer viewHeaderComparePlayer2 = new ViewHeaderComparePlayer(
                player2.getId(),
                player2.getFirstname()+" "+player2.getLastname(),
                team2.getLogo());
        
        List<ViewPlayerComparePlayer> playerCompare = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
                Player currentPlayer;
                Team currentTeam;
                if (i == 0) {
                        currentPlayer = player1;
                        currentTeam = team1;
                } else {
                        currentPlayer = player2;
                        currentTeam = team2;
                }
                // age calculation
                LocalDate today = LocalDate.now();
                LocalDate dateBirthPlayer = currentPlayer.getDateOfBirth();
                Integer age = Period.between(dateBirthPlayer, today).getYears();

                playerCompare.add(new ViewPlayerComparePlayer(
                        currentPlayer.getFirstname()+" "+player1.getLastname(),
                        age,
                        currentPlayer.getCountry(),
                        currentPlayer.getWeight(),
                        currentPlayer.getHeight(),
                        currentTeam.getName(),
                        currentPlayer.getStartYear(),
                        currentPlayer.getCollege(),
                        currentPlayer.getAffiliation(),
                        Player.getRole(currentPlayer.getPos())
                )
                );
        }
        
        List<ViewDataPlayerComparePlayer> dataPlayersCompare = new ArrayList<>();
        List<String> dataNames = List.of("points", "threePointsAttempts", "freeTrowMade", "steals", "rebounds", "threePointsMade");
        List<Integer[]> dataPlayer1 = statsPlayerRepository.findSumDataIdPlayerAndSeason(idPlayer1, season);
        List<Integer[]> dataPlayer2 = statsPlayerRepository.findSumDataIdPlayerAndSeason(idPlayer2, season);
        for(int i = 0; i<dataNames.size();i++){
                dataPlayersCompare.add(
                        new ViewDataPlayerComparePlayer(dataNames.get(i), dataPlayer1.get(0)[i], dataPlayer2.get(0)[i])
                );
        }

        ComparePlayerResponse comparePlayerResponse = new ComparePlayerResponse(viewHeaderComparePlayer1, viewHeaderComparePlayer2, playerCompare, dataPlayersCompare);
        return comparePlayerResponse;
        }
}
