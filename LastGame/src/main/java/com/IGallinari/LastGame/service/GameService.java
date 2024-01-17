package com.IGallinari.LastGame.service;

import com.IGallinari.LastGame.entity.*;
import com.IGallinari.LastGame.payload.response.calendar.ViewTeamCalendar;
import com.IGallinari.LastGame.payload.response.lastFourGames.ViewLastFourGames;
import com.IGallinari.LastGame.payload.response.lastFourGames.ViewLastGame;
import com.IGallinari.LastGame.payload.response.lastFourHtH.HeadToHead;
import com.IGallinari.LastGame.payload.response.lastFourHtH.LastFourHtH;
import com.IGallinari.LastGame.payload.response.calendar.CalendarResponse;
import com.IGallinari.LastGame.payload.response.calendar.ViewGameCalendar;
import com.IGallinari.LastGame.payload.response.home.*;
import com.IGallinari.LastGame.payload.response.gameDetails.pastGame.PastGameResponse;
import com.IGallinari.LastGame.payload.response.gameDetails.pastGame.gameDetails.ViewGameDetailsPastGame;
import com.IGallinari.LastGame.payload.response.gameDetails.pastGame.gameDetails.ViewTeamDetailsPastGame;
import com.IGallinari.LastGame.payload.response.gameDetails.pastGame.pestPlayers.ViewBestPlayerPastGame;
import com.IGallinari.LastGame.payload.response.gameDetails.pastGame.pestPlayers.ViewBestPlayersPerTeamPastGame;
import com.IGallinari.LastGame.payload.response.gameDetails.pastGame.players.ViewPlayerPastGame;
import com.IGallinari.LastGame.payload.response.gameDetails.pastGame.players.ViewPlayerPerTeamPastGame;
import com.IGallinari.LastGame.payload.response.gameDetails.pastGame.quartersForTeam.ViewQuartersPastGame;
import com.IGallinari.LastGame.payload.response.gameDetails.pastGame.quartersForTeam.ViewQuartersTeamPastGame;
import com.IGallinari.LastGame.payload.response.gameDetails.pastGame.statistics.ViewStatisticsPastGame;
import com.IGallinari.LastGame.payload.response.gameDetails.nextGame.gameDetails.ViewGameDetailsNextGame;
import com.IGallinari.LastGame.payload.response.gameDetails.nextGame.gameDetails.ViewTeamDetailsNextGame;
import com.IGallinari.LastGame.payload.response.gameDetails.nextGame.NextGameResponse;
import com.IGallinari.LastGame.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;

    private final StatsGameRepository statsGameRepository;

    private final StatsPlayerRepository statsPlayerRepository;

    private final PlayerRepository playerRepository;

    public HomeResponse buildHomeUnLogged(){
        LocalDate todoayDate = LocalDate.now();
        LocalDate yesterdayDate = todoayDate.minusDays(1);
        List<Game> yesterdayGames = gameRepository.findGameByDate(yesterdayDate);
        List<Game> todayGames = gameRepository.findGameByDate(todoayDate);
        List<com.IGallinari.LastGame.payload.response.home.ViewPastGame> viewPastGames = new ArrayList<>();
        List<com.IGallinari.LastGame.payload.response.home.ViewNextGame> viewNextGames = new ArrayList<>();
        for(Game yesterdayGame: yesterdayGames){
            Team teamHome=yesterdayGame.getHomeTeam();
            Team teamVisitors= yesterdayGame.getVisitorTeam();
            StatsGame statsGameTeamHome= statsGameRepository.findStatsGameByGameAndTeam(yesterdayGame,teamHome);
            StatsGame statsGameTeamVisitor= statsGameRepository.findStatsGameByGameAndTeam(yesterdayGame,teamVisitors);
            viewPastGames.add(
                    new ViewPastGame(
                            yesterdayGame.getId(),
                            new ViewPastTeam(
                                    teamHome.getId(),
                                    teamHome.getNickname(),
                                    teamHome.getLogo(),
                                    statsGameTeamHome.getPoints()
                            ),
                            new ViewPastTeam(
                                    teamVisitors.getId(),
                                    teamVisitors.getNickname(),
                                    teamVisitors.getLogo(),
                                    statsGameTeamVisitor.getPoints()
                            )
                    )
            );
        }
        for(Game todayGame: todayGames){
            Team teamHome=todayGame.getHomeTeam();
            Team teamVisitors= todayGame.getVisitorTeam();
            viewNextGames.add(
                    new ViewNextGame(
                            todayGame.getId(),
                            todayGame.getTime(),
                            new ViewNextTeam(
                                    teamHome.getId(),
                                    teamHome.getNickname(),
                                    teamHome.getLogo()
                            ),
                            new ViewNextTeam(
                                    teamVisitors.getId(),
                                    teamVisitors.getNickname(),
                                    teamVisitors.getLogo()
                            )
                    )
            );
        }
        //aggiungere la parte di blog
        return new HomeResponse(viewPastGames, viewNextGames);
    }

    public CalendarResponse buildCalendar(LocalDate inputDate){

        List<Game> gamesByDate = gameRepository.findGameByDate(inputDate);
        List<ViewGameCalendar> viewGameCalendars = new ArrayList<>();
        for(Game game: gamesByDate){
            Team teamHome=game.getHomeTeam();
            Team teamVisitors= game.getVisitorTeam();
            boolean played=false;
            if(game.getStatus()==3){
                played=true;
            }
            viewGameCalendars.add(
                    new ViewGameCalendar(
                            game.getId(),
                            played,
                            game.getDate(),
                            game.getTime(),
                            new ViewTeamCalendar(
                                    teamHome.getId(),
                                    teamHome.getNickname(),
                                    teamHome.getLogo()
                            ),
                            new ViewTeamCalendar(
                                    teamVisitors.getId(),
                                    teamVisitors.getNickname(),
                                    teamVisitors.getLogo()
                            )
                    )
            );
        }
        return new CalendarResponse(viewGameCalendars);
    }

    public ResponseEntity<?> buildGameDetails(int id){
        Game game = gameRepository.findById(id);
        if (game.getStatus()<3){
            return ResponseEntity.ok(buildNextGame(game));
        }else{
            return ResponseEntity.ok(buildPastGame(game));
        }
    }
    public static Integer[] convertStringToArray(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(String::trim)
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
    }

    public PastGameResponse buildPastGame(Game game){
        Arena arena= game.getArena();
        Team homeTeam= game.getHomeTeam();
        Team visitorTeam= game.getVisitorTeam();
        StatsGame statsGameHome= statsGameRepository.findByTeamAndGame(homeTeam,game);
        StatsGame statsGameVisitor= statsGameRepository.findByTeamAndGame(visitorTeam,game);
        ViewGameDetailsPastGame viewGameDetailsPastGame= new ViewGameDetailsPastGame(
                game.getId(),
                arena.getName(),
                arena.getCity(),
                game.getDate(),
                game.getTime(),
                new ViewTeamDetailsPastGame(
                        homeTeam.getId(),
                        homeTeam.getNickname(),
                        homeTeam.getCode(),
                        homeTeam.getLogo(),
                        statsGameHome.getPoints()
                ),
                new ViewTeamDetailsPastGame(
                        visitorTeam.getId(),
                        visitorTeam.getNickname(),
                        visitorTeam.getCode(),
                        visitorTeam.getLogo(),
                        statsGameVisitor.getPoints()
                )
        );
        Integer[] quartersHome= convertStringToArray(statsGameHome.getPointsPeriod());
        Integer[] quartersVisitor= convertStringToArray(statsGameVisitor.getPointsPeriod());
        ViewQuartersPastGame viewQuartersPastGame = new ViewQuartersPastGame(
                new ViewQuartersTeamPastGame(
                        quartersHome
                ),
                new ViewQuartersTeamPastGame(
                        quartersVisitor
                )
        );
        List<String> arrayStatsType = List.of("fieldShotsMade","freeTrowMade","treePointsMade","assist","blocks","rebound","steals","fouls","turnovers");
        List<Integer> arrayStatsHome = List.of(statsGameHome.getFgm(),statsGameHome.getFtm(),statsGameHome.getTpm(),statsGameHome.getAssists(),statsGameHome.getBlocks(),statsGameVisitor.getTotReb(),statsGameHome.getSteals(),statsGameHome.getPFouls(),statsGameHome.getTurnovers());
        List<Integer> arrayStatsVisitor = List.of(statsGameVisitor.getFgm(),statsGameVisitor.getFtm(),statsGameVisitor.getTpm(),statsGameVisitor.getAssists(),statsGameVisitor.getBlocks(),statsGameVisitor.getTotReb(),statsGameVisitor.getSteals(),statsGameVisitor.getPFouls(),statsGameVisitor.getTurnovers());
        List<ViewStatisticsPastGame> statisticsPastGames= new ArrayList<>();
        for (int i=0;i<arrayStatsType.size();i++){
            statisticsPastGames.add(
                    new ViewStatisticsPastGame(
                            arrayStatsType.get(i),
                            arrayStatsHome.get(i),
                            arrayStatsVisitor.get(i)
                    )
            );
        }
        List<Team> teamList = List.of(homeTeam, visitorTeam);
        List<String> typeBestPlayerList = List.of("points", "rebounds", "assist");
        List<ViewBestPlayerPastGame> homeBestPlayerPastGameList = new ArrayList<>();
        List<ViewBestPlayerPastGame> visitorBestPlayerPastGameList = new ArrayList<>();

        for (Team team : teamList) {
            List<Integer[]> arrayPlayerPoints = statsPlayerRepository.findBestPlayerPointsByIdGameAndIdTeam(game.getId(), team.getId());
            List<Integer[]> arrayPlayerTotReb = statsPlayerRepository.findBestPlayerTotRebByIdGameAndIdTeam(game.getId(), team.getId());
            List<Integer[]> arrayPlayerAssist = statsPlayerRepository.findBestPlayerAssistByIdGameAndIdTeam(game.getId(), team.getId());

            Player playerPoints = playerRepository.findById(arrayPlayerPoints.get(0)[0].intValue());
            Player playerTotReb = playerRepository.findById(arrayPlayerTotReb.get(0)[0].intValue());
            Player playerAssist = playerRepository.findById(arrayPlayerAssist.get(0)[0].intValue());

            List<ViewBestPlayerPastGame> bestPlayerPastGameList;
            if (team.equals(homeTeam)) {
                bestPlayerPastGameList = homeBestPlayerPastGameList;
            } else {
                bestPlayerPastGameList = visitorBestPlayerPastGameList;
            }

            for (int i = 0; i < typeBestPlayerList.size(); i++) {
                bestPlayerPastGameList.add(
                        new ViewBestPlayerPastGame(
                                i == 0 ? playerPoints.getId() : (i == 1 ? playerTotReb.getId() : playerAssist.getId()),
                                i == 0 ? playerPoints.getFirstname() : (i == 1 ? playerTotReb.getFirstname() : playerAssist.getFirstname()),
                                i == 0 ? playerPoints.getLastname() : (i == 1 ? playerTotReb.getLastname() : playerAssist.getLastname()),
                                i == 0 ? playerPoints.getJersey() : (i == 1 ? playerTotReb.getJersey() : playerAssist.getJersey()),
                                i == 0 ? arrayPlayerPoints.get(0)[1] : (i == 1 ? arrayPlayerTotReb.get(0)[1] : arrayPlayerAssist.get(0)[1]),
                                typeBestPlayerList.get(i)
                        )
                );
            }
        }
        ViewBestPlayersPerTeamPastGame bestPlayersPerTeamPastGame = new ViewBestPlayersPerTeamPastGame(homeBestPlayerPastGameList,visitorBestPlayerPastGameList);
        List<HeadToHead> listHeadToHead = builListHeadToHead(homeTeam,visitorTeam,game.getDate());
        LastFourHtH lastFourHtHHome = new LastFourHtH(
                homeTeam.getId(),
                homeTeam.getCode(),
                homeTeam.getLogo(),
                listHeadToHead.subList(0, Math.min(4, listHeadToHead.size()))
        );
        LastFourHtH lastFourHtHVisitor = new LastFourHtH(
                visitorTeam.getId(),
                visitorTeam.getCode(),
                visitorTeam.getLogo(),
                listHeadToHead.subList(Math.max(0, listHeadToHead.size() - 4), listHeadToHead.size())
        );

        List<StatsPlayer> statsPlayerHomeList = statsPlayerRepository.findByTeamAndGame(homeTeam,game);
        List<StatsPlayer> statsPlayerVisitorList = statsPlayerRepository.findByTeamAndGame(visitorTeam,game);
        List<ViewPlayerPastGame> homeplayerPastGameList = new ArrayList<>();
        for (StatsPlayer statsPlayer: statsPlayerHomeList){
            Player player = playerRepository.findById(statsPlayer.getPlayer().getId());
            homeplayerPastGameList.add(new ViewPlayerPastGame(
                    player.getId(),
                    player.getFirstname(),
                    player.getLastname(),
                    player.getJersey(),
                    Player.getRole(statsPlayer.getPos())
            ));
        }
        List<ViewPlayerPastGame> visitorplayerPastGameList = new ArrayList<>();
        for (StatsPlayer statsPlayer: statsPlayerVisitorList){
            Player player = playerRepository.findById(statsPlayer.getPlayer().getId());
            visitorplayerPastGameList.add(new ViewPlayerPastGame(
                    player.getId(),
                    player.getFirstname(),
                    player.getLastname(),
                    player.getJersey(),
                    Player.getRole(statsPlayer.getPos())
            ));
        }
        ViewPlayerPerTeamPastGame  viewPlayerPerTeamPastGame = new ViewPlayerPerTeamPastGame(homeplayerPastGameList,visitorplayerPastGameList);
        return new PastGameResponse(viewGameDetailsPastGame,viewQuartersPastGame,statisticsPastGames,bestPlayersPerTeamPastGame,lastFourHtHHome,lastFourHtHVisitor,viewPlayerPerTeamPastGame);
    }
    public NextGameResponse buildNextGame(Game game){
        Arena arena = game.getArena();
        Team teamHome = game.getHomeTeam();
        Team teamVisitor = game.getVisitorTeam();
        ViewGameDetailsNextGame viewGameDetailsNextGame = new ViewGameDetailsNextGame(
                game.getId(),
                arena.getName(),
                arena.getCity(),
                game.getDate(),
                game.getTime(),
                new ViewTeamDetailsNextGame(
                        teamHome.getId(),
                        teamHome.getNickname(),
                        teamHome.getCode(),
                        teamHome.getLogo()
                ),
                new ViewTeamDetailsNextGame(
                        teamVisitor.getId(),
                        teamVisitor.getNickname(),
                        teamVisitor.getCode(),
                        teamVisitor.getLogo()
                )
        );
        ViewLastFourGames viewLastFourGamesNextGameHome = new ViewLastFourGames(
                teamHome.getId(),
                teamHome.getCode(),
                teamHome.getLogo(),
                buildListViewLastGame(teamHome,game.getDate())
        );
        ViewLastFourGames viewLastFourGamesNextGameVisitor = new ViewLastFourGames(
                teamVisitor.getId(),
                teamVisitor.getCode(),
                teamVisitor.getLogo(),
                buildListViewLastGame(teamVisitor,game.getDate())
        );
        List<HeadToHead> listHeadToHeadGameDetails = builListHeadToHead(teamHome,teamVisitor,game.getDate());
        LastFourHtH lastFourHtHGameDetailsHome = new LastFourHtH(
                teamHome.getId(),
                teamHome.getCode(),
                teamHome.getLogo(),
                listHeadToHeadGameDetails.subList(0, Math.min(4, listHeadToHeadGameDetails.size()))
        );
        LastFourHtH lastFourHtHGameDetailsVisitor = new LastFourHtH(
                teamVisitor.getId(),
                teamVisitor.getCode(),
                teamVisitor.getLogo(),
                listHeadToHeadGameDetails.subList(Math.max(0, listHeadToHeadGameDetails.size() - 4), listHeadToHeadGameDetails.size())
        );
        return new NextGameResponse(viewGameDetailsNextGame, viewLastFourGamesNextGameHome, viewLastFourGamesNextGameVisitor, lastFourHtHGameDetailsHome, lastFourHtHGameDetailsVisitor);
    }
    public List<HeadToHead> builListHeadToHead(Team teamHome, Team teamVisitor,LocalDate gameDate){
        List<HeadToHead> listHeadToHeadGameDetails = new ArrayList<>();
        List<Game> games = gameRepository.findLastFourHtH(teamHome.getId(),teamVisitor.getId(),gameDate);
        for (Game game : games){
            StatsGame statsGame = statsGameRepository.findStatsGameByGameAndTeam(game,teamHome);
            listHeadToHeadGameDetails.add(
                    new HeadToHead(
                            game.getId(),
                            statsGame.getPoints()
                    )
            );
        }
        for (Game game : games){
            StatsGame statsGame = statsGameRepository.findStatsGameByGameAndTeam(game,teamVisitor);
            listHeadToHeadGameDetails.add(
                    new HeadToHead(
                            game.getId(),
                            statsGame.getPoints()
                    )
            );
        }
        return listHeadToHeadGameDetails;
    }

    public List<ViewLastGame> buildListViewLastGame(Team team,LocalDate gameDate){
        List<ViewLastGame> lastGames = new ArrayList<>();
        List<Game> games= gameRepository.findLastFourGameByTeam(team.getId(),gameDate);
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
}
