package com.IGallinari.LastGame.service;

import com.IGallinari.LastGame.entity.*;
import com.IGallinari.LastGame.payload.request.TokenRequest;
import com.IGallinari.LastGame.payload.request.home.HomeRequest;
import com.IGallinari.LastGame.payload.response.calendar.ViewTeamCalendar;
import com.IGallinari.LastGame.payload.response.home.blog.ViewBlogHome;
import com.IGallinari.LastGame.payload.response.home.nextGame.ViewNextGame;
import com.IGallinari.LastGame.payload.response.home.nextGame.ViewNextTeam;
import com.IGallinari.LastGame.payload.response.home.pastGame.ViewPastGame;
import com.IGallinari.LastGame.payload.response.home.pastGame.ViewPastTeam;
import com.IGallinari.LastGame.payload.response.home.standigs.ViewTeamStandingHome;
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
/**
 * Service class for managing game-related operations.
 * This includes building responses for various game views such as home, calendar, and game details.
 */
@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;

    private final StatsGameRepository statsGameRepository;

    private final StatsPlayerRepository statsPlayerRepository;

    private final StatsTeamRepository statsTeamRepository;

    private final PlayerRepository playerRepository;

    private final TeamRepository teamRepository;

    private final UserRepository userRepository;

    private final BlogRepository blogRepository;

    private final FavTeamRepository favTeamRepository;

    private final FavPlayerRepository favPlayerRepository;

    private final JwtService jwtService;
    /**
     * Builds and returns the home view response based on the given home request.
     * The response varies depending on whether the user is logged in or not.
     *
     * @param homeRequest The request data for building the home view.
     * @return A ResponseEntity containing the home view response.
     */
    public ResponseEntity<?> buildHome(HomeRequest homeRequest){
        String token = homeRequest.getToken();
        LocalDate date = homeRequest.getDate();
        if(jwtService.isTokenValid(token)){
            int idUser = jwtService.getIdUser(token);
            User user = userRepository.findById(idUser);
            return ResponseEntity.ok(buildHomeLogged(user,date));
        }else{
            return ResponseEntity.ok(buildHomeUnLogged(date));
        }
    }
    /**
     * Builds a home view response for a logged-in user.
     *
     * @param user The user for whom the home view is built.
     * @param date The date for which the home view is generated.
     * @return A HomeLoggedResponse containing home view data for a logged-in user.
     */
    private HomeLoggedResponse buildHomeLogged(User user,LocalDate date){
        LocalDate pastDate = date.minusDays(1);
        List<Game> pastGames = gameRepository.findGameByDate(pastDate);
        List<Game> nextGames = gameRepository.findGameByDate(date);
        List<Integer> favTeams = favTeamRepository.findFavTeamsByUser(user.getId());
        List<Game> favPastGame = new ArrayList<>();
        List<Game> favNextGame = new ArrayList<>();
        List<ViewTeamStandingHome> eastStandings= new ArrayList<>();
        List<ViewTeamStandingHome> westStandings= new ArrayList<>();
        int season = gameRepository.findCurrentSeason();
        for(Integer idTeam: favTeams){
            favPastGame.add(gameRepository.findPastGameByIdTeam(idTeam));
            favNextGame.add(gameRepository.findNextGameByIdTeam(idTeam));
            Team team = teamRepository.findById((int)idTeam);
            StatsTeam  statsTeam = statsTeamRepository.findByTeamAndSeason(team,season);
            if(team.getDivision().equals("East")){
                eastStandings.add(
                        new ViewTeamStandingHome(
                                team.getId(),
                                team.getNickname(),
                                team.getLogo(),
                                statsTeam.getRankConference()
                        )
                );
            }else{
                westStandings.add(
                        new ViewTeamStandingHome(
                                team.getId(),
                                team.getNickname(),
                                team.getLogo(),
                                statsTeam.getRankConference()
                        )
                );
            }
        }
        List<ViewPastGame> viewPastGames = buildPastGame(pastGames);
        List<ViewPastGame> viewFavPastGame = buildPastGame(favPastGame);
        List<ViewNextGame> viewNextGames = buildNextGame(nextGames);
        List<ViewNextGame> viewFavNextGame = buildNextGame(favNextGame);
        List<ViewBlogHome> viewBlogHomes = buildBlogHome();

        return new HomeLoggedResponse(true,viewPastGames, viewFavPastGame,viewNextGames,viewFavNextGame,eastStandings,westStandings,viewBlogHomes);
    }
    /**
     * Builds a home view response for an unlogged user.
     *
     * @param date The date for which the home view is generated.
     * @return A HomeUnLoggedResponse containing home view data for an unlogged user.
     */
    private HomeUnLoggedResponse buildHomeUnLogged(LocalDate date){
        LocalDate pastDate = date.minusDays(1);
        List<Game> pastGames = gameRepository.findGameByDate(pastDate);
        List<Game> nextGames = gameRepository.findGameByDate(date);
        List<ViewPastGame> viewPastGames = buildPastGame(pastGames);
        List<ViewNextGame> viewNextGames = buildNextGame(nextGames);
        List<ViewBlogHome> viewBlogHomes = buildBlogHome();
        return new HomeUnLoggedResponse(false,viewPastGames, viewNextGames,viewBlogHomes);
    }
    /**
     * Builds a list of recent blog posts for the home view.
     *
     * @return A list of ViewBlogHome objects representing recent blog posts.
     */
    private List<ViewBlogHome> buildBlogHome(){
        List<Blog> lastFourBlogs = blogRepository.findLastFourBlogs();
        List<ViewBlogHome> viewBlogHomes = new ArrayList<>();
        for(Blog blog: lastFourBlogs){
            viewBlogHomes.add(
                    new ViewBlogHome(
                            blog.getId(),
                            blog.getTitle(),
                            blog.getSubtitle(),
                            blog.getImg(),
                            blog.getDate()
                    )
            );
        }
        return viewBlogHomes;
    }
    /**
     * Builds a list of ViewPastGame objects from a list of Game objects.
     *
     * @param games The list of Game objects to convert to past game views.
     * @return A list of ViewPastGame objects representing past games.
     */
    private List<ViewPastGame> buildPastGame(List<Game> games){
        List<ViewPastGame> viewPastGames = new ArrayList<>();
        for(Game game: games){
            Team teamHome=game.getHomeTeam();
            Team teamVisitors= game.getVisitorTeam();
            StatsGame statsGameTeamHome= statsGameRepository.findStatsGameByGameAndTeam(game,teamHome);
            StatsGame statsGameTeamVisitor= statsGameRepository.findStatsGameByGameAndTeam(game,teamVisitors);
            viewPastGames.add(
                    new ViewPastGame(
                            game.getId(),
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
        return viewPastGames;
    }
    /**
     * Builds a list of ViewNextGame objects from a list of Game objects.
     *
     * @param games The list of Game objects to convert to next game views.
     * @return A list of ViewNextGame objects representing upcoming games.
     */
    private List<ViewNextGame> buildNextGame(List<Game> games){
        List<ViewNextGame> viewNextGames = new ArrayList<>();
        for(Game game: games){
            Team teamHome=game.getHomeTeam();
            Team teamVisitors= game.getVisitorTeam();
            viewNextGames.add(
                    new ViewNextGame(
                            game.getId(),
                            game.getTime(),
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
        return viewNextGames;
    }
    /**
     * Builds a calendar view response based on the input date.
     *
     * @param inputDate The date for which to build the calendar view.
     * @return A CalendarResponse containing calendar view data.
     */
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
    /**
     * Builds a game details view response for a specific game.
     *
     * @param tokenRequest The token request for user authentication.
     * @param id           The ID of the game for which to build the details view.
     * @return A ResponseEntity containing the game details view response.
     */
    public ResponseEntity<?> buildGameDetails(TokenRequest tokenRequest, int id){
        Game game = gameRepository.findById(id);
        String token = tokenRequest.getToken();
        Integer idUser=null;
        if (jwtService.isTokenValid(token)){
            idUser = jwtService.getIdUser(token);
        }
        if (game.getStatus()<3){
            return ResponseEntity.ok(buildNextGame(idUser,game));
        }else{
            return ResponseEntity.ok(buildPastGame(idUser,game));
        }
    }
    /**
     * Converts a comma-separated string of numbers into an array of integers.
     *
     * @param numbers The string containing comma-separated numbers.
     * @return An array of integers where each element represents a parsed number from the input string.
     */
    private static Integer[] convertStringToArray(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(String::trim)
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
    }
    /**
     * Builds a game details view response for a past game.
     *
     * @param idUser The ID of the user (if logged in).
     * @param game   The Game object representing the past game.
     * @return A PastGameResponse containing details of the past game.
     */
    public PastGameResponse buildPastGame(Integer idUser, Game game){
        Arena arena= game.getArena();
        Team homeTeam= game.getHomeTeam();
        Team visitorTeam= game.getVisitorTeam();
        boolean logged = false;
        boolean favHome= false;
        boolean favVisitor= false;
        if(idUser!=null){
            logged = true;
            favHome = favTeamRepository.existsByIdUserAndIdTeam(idUser,homeTeam.getId()) ==1;
            favVisitor = favTeamRepository.existsByIdUserAndIdTeam(idUser,visitorTeam.getId()) ==1;
        }
        StatsGame statsGameHome= statsGameRepository.findByTeamAndGame(homeTeam,game);
        StatsGame statsGameVisitor= statsGameRepository.findByTeamAndGame(visitorTeam,game);
        ViewGameDetailsPastGame viewGameDetailsPastGame= new ViewGameDetailsPastGame(
                game.getId(),
                arena.getName(),
                arena.getCity(),
                game.getDate(),
                game.getTime(),
                new ViewTeamDetailsPastGame(
                        favHome,
                        homeTeam.getId(),
                        homeTeam.getNickname(),
                        homeTeam.getCode(),
                        homeTeam.getLogo(),
                        statsGameHome.getPoints()
                ),
                new ViewTeamDetailsPastGame(
                        favVisitor,
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
            boolean favourite= false;
            if (idUser!=null){
                favourite = favPlayerRepository.existsByIdUserAndIdPlayer(idUser,player.getId()) ==1;
            }
            homeplayerPastGameList.add(new ViewPlayerPastGame(
                    favourite,
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
            boolean favourite= false;
            if (idUser!=null){
                favourite = favPlayerRepository.existsByIdUserAndIdPlayer(idUser,player.getId()) ==1;
            }
            visitorplayerPastGameList.add(new ViewPlayerPastGame(
                    favourite,
                    player.getId(),
                    player.getFirstname(),
                    player.getLastname(),
                    player.getJersey(),
                    Player.getRole(statsPlayer.getPos())
            ));
        }
        ViewPlayerPerTeamPastGame  viewPlayerPerTeamPastGame = new ViewPlayerPerTeamPastGame(homeplayerPastGameList,visitorplayerPastGameList);
        return new PastGameResponse(logged,true,viewGameDetailsPastGame,viewQuartersPastGame,statisticsPastGames,bestPlayersPerTeamPastGame,lastFourHtHHome,lastFourHtHVisitor,viewPlayerPerTeamPastGame);
    }
    /**
     * Builds a game details view response for an upcoming game.
     *
     * @param idUser The ID of the user (if logged in).
     * @param game   The Game object representing the upcoming game.
     * @return A NextGameResponse containing details of the upcoming game.
     */
    public NextGameResponse buildNextGame(Integer idUser, Game game){
        Arena arena = game.getArena();
        Team homeTeam = game.getHomeTeam();
        Team visitorTeam = game.getVisitorTeam();
        boolean logged = false;
        boolean favHome= false;
        boolean favVisitor= false;
        if(idUser!=null){
            logged = true;
            favHome = favTeamRepository.existsByIdUserAndIdTeam(idUser,homeTeam.getId()) ==1;
            favVisitor = favTeamRepository.existsByIdUserAndIdTeam(idUser,visitorTeam.getId()) ==1;
        }
        ViewGameDetailsNextGame viewGameDetailsNextGame = new ViewGameDetailsNextGame(
                game.getId(),
                arena.getName(),
                arena.getCity(),
                game.getDate(),
                game.getTime(),
                new ViewTeamDetailsNextGame(
                        favHome,
                        homeTeam.getId(),
                        homeTeam.getNickname(),
                        homeTeam.getCode(),
                        homeTeam.getLogo()
                ),
                new ViewTeamDetailsNextGame(
                        favVisitor,
                        visitorTeam.getId(),
                        visitorTeam.getNickname(),
                        visitorTeam.getCode(),
                        visitorTeam.getLogo()
                )
        );
        ViewLastFourGames viewLastFourGamesNextGameHome = new ViewLastFourGames(
                homeTeam.getId(),
                homeTeam.getCode(),
                homeTeam.getLogo(),
                buildListViewLastGame(homeTeam,game.getDate())
        );
        ViewLastFourGames viewLastFourGamesNextGameVisitor = new ViewLastFourGames(
                visitorTeam.getId(),
                visitorTeam.getCode(),
                visitorTeam.getLogo(),
                buildListViewLastGame(visitorTeam,game.getDate())
        );
        List<HeadToHead> listHeadToHeadGameDetails = builListHeadToHead(homeTeam,visitorTeam,game.getDate());
        LastFourHtH lastFourHtHGameDetailsHome = new LastFourHtH(
                homeTeam.getId(),
                homeTeam.getCode(),
                homeTeam.getLogo(),
                listHeadToHeadGameDetails.subList(0, Math.min(4, listHeadToHeadGameDetails.size()))
        );
        LastFourHtH lastFourHtHGameDetailsVisitor = new LastFourHtH(
                visitorTeam.getId(),
                visitorTeam.getCode(),
                visitorTeam.getLogo(),
                listHeadToHeadGameDetails.subList(Math.max(0, listHeadToHeadGameDetails.size() - 4), listHeadToHeadGameDetails.size())
        );
        return new NextGameResponse(logged,false,viewGameDetailsNextGame, viewLastFourGamesNextGameHome, viewLastFourGamesNextGameVisitor, lastFourHtHGameDetailsHome, lastFourHtHGameDetailsVisitor);
    }
    /**
     * Builds a list of HeadToHead objects representing the recent head-to-head games between two teams.
     *
     * @param teamHome     The home team in the head-to-head comparison.
     * @param teamVisitor  The visiting team in the head-to-head comparison.
     * @param gameDate     The date of the game for which head-to-head data is retrieved.
     * @return A list of HeadToHead objects representing head-to-head game results.
     */
    private List<HeadToHead> builListHeadToHead(Team teamHome, Team teamVisitor,LocalDate gameDate){
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
    /**
     * Builds a list of ViewLastGame objects representing recent games of a team.
     *
     * @param team     The team for which to retrieve recent game results.
     * @param gameDate The date of the game for which results are retrieved.
     * @return A list of ViewLastGame objects representing recent game results for the team.
     */
    private List<ViewLastGame> buildListViewLastGame(Team team,LocalDate gameDate){
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
