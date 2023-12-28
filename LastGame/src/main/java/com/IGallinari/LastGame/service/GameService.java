package com.IGallinari.LastGame.service;

import com.IGallinari.LastGame.entity.Game;
import com.IGallinari.LastGame.entity.StatsGame;
import com.IGallinari.LastGame.entity.Team;
import com.IGallinari.LastGame.payload.response.Calendar.CalendarResponse;
import com.IGallinari.LastGame.payload.response.Calendar.ViewGameCalendar;
import com.IGallinari.LastGame.payload.response.Calendar.ViewTeamCalendar;
import com.IGallinari.LastGame.payload.response.Home.*;
import com.IGallinari.LastGame.repository.GameRepository;
import com.IGallinari.LastGame.repository.StatsGameRepository;
import com.IGallinari.LastGame.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
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
        List<PastViewGame> pastViewGames = new ArrayList<>();
        List<NextViewGame> nextViewGames = new ArrayList<>();
        for(Game yesterdayGame: yesterdayGames){
            Team teamHome=yesterdayGame.getHomeTeam();
            Team teamVisitors= yesterdayGame.getVisitorTeam();
            StatsGame statsGameTeamHome= statsGameRepository.findStatsGameByGameAndTeam(yesterdayGame,teamHome);
            StatsGame statsGameTeamVisitor= statsGameRepository.findStatsGameByGameAndTeam(yesterdayGame,teamVisitors);
            pastViewGames.add(
                    new PastViewGame(
                            yesterdayGame.getId(),
                            new PastViewTeam(
                                    teamHome.getId(),
                                    teamHome.getNickname(),
                                    teamHome.getLogo(),
                                    statsGameTeamHome.getPoints()
                            ),
                            new PastViewTeam(
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
            nextViewGames.add(
                    new NextViewGame(
                            todayGame.getId(),
                            todayGame.getTime(),
                            new NextViewTeam(
                                    teamHome.getId(),
                                    teamHome.getNickname(),
                                    teamHome.getLogo()
                            ),
                            new NextViewTeam(
                                    teamVisitors.getId(),
                                    teamVisitors.getNickname(),
                                    teamVisitors.getLogo()
                            )
                    )
            );
        }
        return new HomeResponse(pastViewGames,nextViewGames);
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


}
