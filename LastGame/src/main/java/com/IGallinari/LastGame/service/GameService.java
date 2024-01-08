package com.IGallinari.LastGame.service;

import com.IGallinari.LastGame.entity.Arena;
import com.IGallinari.LastGame.entity.Game;
import com.IGallinari.LastGame.entity.StatsGame;
import com.IGallinari.LastGame.entity.Team;
import com.IGallinari.LastGame.payload.response.Calendar.CalendarResponse;
import com.IGallinari.LastGame.payload.response.Calendar.ViewGameCalendar;
import com.IGallinari.LastGame.payload.response.Calendar.ViewTeamCalendar;
import com.IGallinari.LastGame.payload.response.Home.*;
import com.IGallinari.LastGame.payload.response.NextGame.GameDetails.ViewGameDetails;
import com.IGallinari.LastGame.payload.response.NextGame.GameDetails.ViewTeamDetails;
import com.IGallinari.LastGame.payload.response.NextGame.LastFourGames.ViewLastFourGames;
import com.IGallinari.LastGame.payload.response.NextGame.LastFourGames.ViewLastGame;
import com.IGallinari.LastGame.payload.response.NextGame.LastFourHtH.HeadToHead;
import com.IGallinari.LastGame.payload.response.NextGame.LastFourHtH.LastFourHtH;
import com.IGallinari.LastGame.payload.response.NextGame.NextGameResponse;
import com.IGallinari.LastGame.repository.GameRepository;
import com.IGallinari.LastGame.repository.StatsGameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;

    private final StatsGameRepository statsGameRepository;

    public HomeResponse buildHomeUnLogged(){
        LocalDate todoayDate = LocalDate.now();
        LocalDate yesterdayDate = todoayDate.minusDays(1);
        List<Game> yesterdayGames = gameRepository.findGameByDate(yesterdayDate);
        List<Game> todayGames = gameRepository.findGameByDate(todoayDate);
        List<ViewPastGame> viewPastGames = new ArrayList<>();
        List<ViewNextGame> viewNextGames = new ArrayList<>();
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
        return new HomeResponse(viewPastGames, viewNextGames);
    }

    public CalendarResponse buildCalendar(LocalDate inputDate){
        List<Game> gamesByDate = gameRepository.findGameByDate(inputDate);
        List<ViewGameCalendar> viewGameCalendars = new ArrayList<>();
        for(Game game: gamesByDate){
            Team teamHome=game.getHomeTeam();
            Team teamVisitors= game.getVisitorTeam();
            viewGameCalendars.add(
                    new ViewGameCalendar(
                            game.getId(),
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


    public NextGameResponse buildNextGame(int id){
        Game game = gameRepository.findById(id);
        Arena arena = game.getArena();
        Team teamHome = game.getHomeTeam();
        Team teamVisitor = game.getVisitorTeam();
        ViewGameDetails viewGameDetails = new ViewGameDetails(
                game.getId(),
                arena.getName(),
                arena.getCity(),
                game.getDate(),
                game.getTime(),
                new ViewTeamDetails(
                        teamHome.getId(),
                        teamHome.getNickname(),
                        teamHome.getLogo()
                ),
                new ViewTeamDetails(
                        teamVisitor.getId(),
                        teamVisitor.getNickname(),
                        teamHome.getLogo()
                )
        );
        ViewLastFourGames viewLastFourGamesHome = new ViewLastFourGames(
                teamHome.getId(),
                teamHome.getCode(),
                teamHome.getLogo(),
                buildListViewLastGame(teamHome)
        );
        ViewLastFourGames viewLastFourGamesVisitor = new ViewLastFourGames(
                teamVisitor.getId(),
                teamVisitor.getCode(),
                teamVisitor.getLogo(),
                buildListViewLastGame(teamVisitor)
        );
        List<HeadToHead> listHeadToHead = builListHeadToHead(teamHome,teamVisitor);
        LastFourHtH lastFourHtHHome = new LastFourHtH(
                teamHome.getId(),
                teamHome.getCode(),
                teamHome.getLogo(),
                listHeadToHead.subList(0, Math.min(4, listHeadToHead.size()))
        );
        LastFourHtH lastFourHtHVisitor= new LastFourHtH(
                teamVisitor.getId(),
                teamVisitor.getCode(),
                teamVisitor.getLogo(),
                listHeadToHead.subList(Math.max(0, listHeadToHead.size() - 4), listHeadToHead.size())
        );
        return new NextGameResponse(viewGameDetails, viewLastFourGamesHome, viewLastFourGamesVisitor,lastFourHtHHome,lastFourHtHVisitor);
    }
    public List<HeadToHead> builListHeadToHead(Team teamHome, Team teamVisitor){
        List<HeadToHead> listHeadToHead = new ArrayList<>();
        List<Game> games = gameRepository.findLastFourHtH(teamHome.getId(),teamVisitor.getId());
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

    public List<ViewLastGame> buildListViewLastGame(Team team){
        List<ViewLastGame> lastGames = new ArrayList<>();
        List<Game> games= gameRepository.findLastFourGameByTeam(team.getId());
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
