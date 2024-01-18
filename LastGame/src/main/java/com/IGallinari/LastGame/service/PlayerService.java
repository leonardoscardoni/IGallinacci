package com.IGallinari.LastGame.service;


import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;


import com.IGallinari.LastGame.payload.request.TokenRequest;
import com.IGallinari.LastGame.payload.response.NeedToBeLoggedResponse;
import com.IGallinari.LastGame.payload.response.playerDetails.*;
import com.IGallinari.LastGame.payload.response.comparison.player.ComparePlayersResponse;
import com.IGallinari.LastGame.payload.response.comparison.player.ViewDataPlayerComparePlayer;
import com.IGallinari.LastGame.payload.response.comparison.player.ViewHeaderComparePlayer;
import com.IGallinari.LastGame.payload.response.comparison.player.ViewPlayerComparePlayer;
import com.IGallinari.LastGame.payload.response.listPlayerFilter.PlayerFilterResponse;
import com.IGallinari.LastGame.payload.response.listPlayerFilter.ViewRolesPlayerFilter;
import com.IGallinari.LastGame.payload.response.listPlayerFilter.ViewTeamsPlayerFilter;
import com.IGallinari.LastGame.payload.response.playerDetailsByGame.*;
import com.IGallinari.LastGame.payload.response.playerTeamFilter.PlayerTeamFilterResponse;
import com.IGallinari.LastGame.payload.response.playerTeamFilter.ViewPlayersPlayerTeamFilter;
import org.springframework.http.ResponseEntity;
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

    private final FavPlayerRepository favPlayerRepository;

    private final FavTeamRepository favTeamRepository;

    private final JwtService jwtService;

    public PlayerTeamFilterResponse buildPlayerTeamFilterResponse(TokenRequest tokenRequest,int idTeam, int season){
        String token = tokenRequest.getToken();
        boolean logged = jwtService.isTokenValid(token);
        Integer idUser= null;
        if (logged){
            idUser = jwtService.getIdUser(token);
        }
        Team team = teamRepository.findById(idTeam);
        List<ViewPlayersPlayerTeamFilter> players = new ArrayList<>();
        List<PlayerTeam> playersTeam = playerTeamRepository.findByTeamAndSeason(team, season);
        boolean favourite = false;
        for (PlayerTeam playerTeam: playersTeam){
            Player player = playerTeam.getPlayer();
            if(idUser!=null){
                favourite = favPlayerRepository.existsByIdUserAndIdPlayer(idUser, player.getId()) ==1;
            }
            players.add(
                    new ViewPlayersPlayerTeamFilter(
                        favourite,
                        player.getId(),
                        player.getFirstname(),
                        player.getLastname(),
                        Player.getRole(player.getPos()),
                        player.getJersey(),
                        player.getCountry()
                    )
            );
        }
        if (idUser!=null){
            favourite = favTeamRepository.existsByIdUserAndIdTeam(idUser, team.getId()) ==1;
        }
        return new PlayerTeamFilterResponse(
            logged,
            favourite,
            team.getId(),
            team.getLogo(),
            team.getNickname(),
            team.getName(),
            season,
            players
        );
    }

    public PlayerDetailsByGameResponse buildPlayerDetailsByGameResponse (TokenRequest tokenRequest,int idGame, int idPlayer){
        String token = tokenRequest.getToken();
        boolean logged = jwtService.isTokenValid(token);
        boolean favourite = false;
        if (logged){
            int idUser = jwtService.getIdUser(token);
            favourite = favPlayerRepository.existsByIdUserAndIdPlayer(idUser, idPlayer) ==1;
        }
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
                teamHome.getId(),
                teamHome.getName(),
                teamHome.getNickname(),
                teamHome.getLogo(),
                statsGameHome.getPoints()
        );
        ViewTeamPlayerDetailsByGame viewVisitorTeamPlayerDetailsByGame = new ViewTeamPlayerDetailsByGame(
                teamVisitor.getId(),
                teamVisitor.getName(),
                teamVisitor.getNickname(),
                teamVisitor.getLogo(),
                statsGameVisitor.getPoints()
        );
        ViewPlayerInfoPlayerDetailsByGame viewPlayerInfoPlayerDetailsByGame = new ViewPlayerInfoPlayerDetailsByGame(
                favourite,
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
        return new PlayerDetailsByGameResponse(
                logged,
                game.getId(),
                viewHeaderPlayerDetailsByGame,
                viewHomeTeamPlayerDetailsByGame,
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

    public PlayerDetailsResponse buildDetailsPlayerIndependentByGameResponse(TokenRequest tokenRequest, int idPlayer, int season) {
        Player player = playerRepository.findById(idPlayer);
        List<Object[]> sumStatsPlayerAndAvgPointsArray = statsPlayerRepository.findSumStatsPlayerAndAvgPointsByIdPlayerAndSeason(idPlayer, season);
        Team team= teamRepository.findById((int)statsPlayerRepository.findLastTeamPlayer(idPlayer,season));
        int idTeam = team.getId();
        String token = tokenRequest.getToken();
        boolean logged = jwtService.isTokenValid(token);
        boolean favouritePlayer = false;
        boolean favouriteTeam = false;
        if(logged){
            int idUser = jwtService.getIdUser(token);
            favouritePlayer = favPlayerRepository.existsByIdUserAndIdPlayer(idUser,idPlayer) ==1;
            favouriteTeam = favTeamRepository.existsByIdUserAndIdTeam(idUser,idTeam) ==1;
        }
        String firstName = player.getFirstname();
        String lastName = player.getLastname();
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
                logged,
                favouritePlayer,
                idPlayer,
                firstName,
                lastName,
                favouriteTeam,
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

    public ResponseEntity<?> buildComparePlayersResponse(TokenRequest tokenRequest, int idPlayer1, int idPlayer2, int season){
        String token = tokenRequest.getToken();
        boolean logged = jwtService.isTokenValid(token);
        if(!logged){
            return ResponseEntity.ok(new NeedToBeLoggedResponse());
        }
        int idUser = jwtService.getIdUser(token);
        Player player1 = playerRepository.findById(idPlayer1);
        Player player2 = playerRepository.findById(idPlayer2);
        Integer idTeam1 = statsPlayerRepository.findLastTeamPlayer(idPlayer1, season);
        Integer idTeam2 = statsPlayerRepository.findLastTeamPlayer(idPlayer2, season);
        Team team1 = teamRepository.findById(idTeam1.intValue());
        Team team2 = teamRepository.findById(idTeam2.intValue());
        boolean favouritePlayer1 = favPlayerRepository.existsByIdUserAndIdPlayer(idUser, idPlayer1) ==1;
        boolean favouritePlayer2 = favPlayerRepository.existsByIdUserAndIdPlayer(idUser, idPlayer2) ==1;

        ViewHeaderComparePlayer viewHeaderComparePlayer1 = new ViewHeaderComparePlayer(
                favouritePlayer1,
                player1.getId(),
                player1.getFirstname(),
                player1.getLastname(),
                team1.getLogo());
        ViewHeaderComparePlayer viewHeaderComparePlayer2 = new ViewHeaderComparePlayer(
                favouritePlayer2,
                player2.getId(),
                player2.getFirstname(),
                player2.getLastname(),
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
                LocalDate today = LocalDate.now();
                LocalDate dateBirthPlayer = currentPlayer.getDateOfBirth();
                Integer age = Period.between(dateBirthPlayer, today).getYears();

                playerCompare.add(new ViewPlayerComparePlayer(
                        currentPlayer.getFirstname(),
                        currentPlayer.getLastname(),
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

        ComparePlayersResponse comparePlayersResponse = new ComparePlayersResponse(viewHeaderComparePlayer1, viewHeaderComparePlayer2, playerCompare, dataPlayersCompare);
        return ResponseEntity.ok(comparePlayersResponse);
        }
}
