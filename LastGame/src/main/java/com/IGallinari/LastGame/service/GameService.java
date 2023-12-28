package com.IGallinari.LastGame.service;

<<<<<<< Updated upstream
public class GameService {
}
=======
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
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {
    private GameRepository gameRepository;

    private TeamRepository teamRepository;

    private StatsGameRepository statsGameRepository;

    public List<Game> getGamesByDate(LocalDate inputDate){
        return gameRepository.findGameByDate(inputDate);
    }

    public HomeResponse buildHomeUnLogged(){
        LocalDate todoayDate = LocalDate.now();
        LocalDate yesterdayDate = todoayDate.minusDays(1);
        List<Game> yesterdayGames = gameRepository.findGameByDate(yesterdayDate);
        List<Game> todayGames = gameRepository.findGameByDate(todoayDate);
        List<PastResultGame> pastResultGames = Collections.emptyList();
        List<NextViewGame> nextViewGames = Collections.emptyList();
        for(Game yesterdayGame: yesterdayGames){
            Team teamHome=yesterdayGame.getHomeTeam();
            Team teamVisitors= yesterdayGame.getVisitorTeam();
            StatsGame statsGameTeamHome= statsGameRepository.findStatsGameByGameAndTAndTeam(yesterdayGame,teamHome);
            StatsGame statsGameTeamVisitor= statsGameRepository.findStatsGameByGameAndTAndTeam(yesterdayGame,teamVisitors);
            pastResultGames.add(
                    new PastResultGame(
                            yesterdayGame.getId(),
                            new PastResultTeam(
                                    teamHome.getId(),
                                    teamHome.getNickname(),
                                    teamHome.getLogo(),
                                    statsGameTeamHome.getPoints()
                            ),
                            new PastResultTeam(
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
                                    teamHome.getNickname(),
                                    teamHome.getLogo()
                            ),
                            new NextViewTeam(
                                    teamVisitors.getNickname(),
                                    teamVisitors.getLogo()
                            )
                    )
            );
        }
        return new HomeResponse(pastResultGames,nextViewGames);
    }

    public CalendarResponse buildCalendar(LocalDate inputDate){
        List<Game> gamesByDate = gameRepository.findGameByDate(inputDate);
        List<ViewGameCalendar> viewGameCalendars = Collections.emptyList();
        for(Game game: gamesByDate){
            Team teamHome=game.getHomeTeam();
            Team teamVisitors= game.getVisitorTeam();
            viewGameCalendars.add(
                    new ViewGameCalendar(
                            game.getDate(),
                            game.getTime(),
                            new ViewTeamCalendar(
                                    teamHome.getNickname(),
                                    teamHome.getLogo()
                            ),
                            new ViewTeamCalendar(
                                    teamVisitors.getNickname(),
                                    teamVisitors.getLogo()
                            )
                    )
            );
        }
        return new CalendarResponse(viewGameCalendars);
    }
}
>>>>>>> Stashed changes
