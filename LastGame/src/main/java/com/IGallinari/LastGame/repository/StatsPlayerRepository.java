package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This interface represents the repository for managing StatsPlayer entities.
 * It extends the JpaRepository interface provided by Spring Data JPA.
 *
 */
@Repository
public interface StatsPlayerRepository extends JpaRepository<StatsPlayer,Integer> {

    /**
     * Calculates the average statistics for a player based on their player ID.
     *
     * @param idPlayer The ID of the player for which to calculate average statistics.
     * @return List of average statistics [average points, average assists, average total rebounds, average steals, average blocks].
     */
    @Query(value = "SELECT AVG(sp.points),AVG(sp.assists),AVG(sp.totReb),AVG(sp.steals),AVG(sp.blocks) FROM statsplayer sp WHERE idPlayer=:inputIdPlayer", nativeQuery = true)
    List<Float[]> findAvgStatsByIdPlayer(@Param("inputIdPlayer") int idPlayer);

    /**
     * Retrieves the stats for a specific team, game, and player.
     *
     * @param team   The team for which to retrieve stats.
     * @param game   The game for which to retrieve stats.
     * @param player The player for which to retrieve stats.
     * @return The StatsPlayer object for the specified team, game, and player or null if not found.
     */
    StatsPlayer findByTeamAndGameAndPlayer(Team team, Game game, Player player);

    /**
     * Retrieves a list of stats for a specific team and game.
     *
     * @param team The team for which to retrieve stats.
     * @param game The game for which to retrieve stats.
     * @return List of StatsPlayer objects for the specified team and game.
     */
    List<StatsPlayer> findByTeamAndGame(Team team,Game game);

    /**
     * Retrieves the player ID and points of the best player (the highest points) for a specific game and team.
     *
     * @param idGame The ID of the game for which to find the best player.
     * @param idTeam The ID of the team for which to find the best player.
     * @return List of Integer arrays [player ID, points] for the best player in the specified game and team.
     */
    @Query(value = "SELECT idPlayer, points FROM statsplayer WHERE idGame = :inputIdGame AND idTeam = :inputIdTeam ORDER BY points DESC LIMIT 1", nativeQuery = true)
    List<Integer[]> findBestPlayerPointsByIdGameAndIdTeam(@Param("inputIdGame") int idGame, @Param("inputIdTeam") int idTeam);

    /**
     * Retrieves the player ID and total rebounds of the best player (highest total rebounds) for a specific game and team.
     *
     * @param idGame The ID of the game for which to find the best player.
     * @param idTeam The ID of the team for which to find the best player.
     * @return List of Integer arrays [player ID, total rebounds] for the best player in the specified game and team.
     */
    @Query(value = "SELECT idPlayer, totReb FROM statsplayer WHERE idGame = :inputIdGame AND idTeam = :inputIdTeam ORDER BY totReb DESC LIMIT 1", nativeQuery = true)
    List<Integer[]> findBestPlayerTotRebByIdGameAndIdTeam(@Param("inputIdGame") int idGame, @Param("inputIdTeam") int idTeam);

    /**
     * Retrieves the player ID and assists of the best player (The highest assists) for a specific game and team.
     *
     * @param idGame The ID of the game for which to find the best player.
     * @param idTeam The ID of the team for which to find the best player.
     * @return List of Integer arrays [player ID, assists] for the best player in the specified game and team.
     */
    @Query(value = "SELECT idPlayer, assists FROM statsplayer WHERE idGame = :inputIdGame AND idTeam = :inputIdTeam ORDER BY assists DESC LIMIT 1", nativeQuery = true)
    List<Integer[]> findBestPlayerAssistByIdGameAndIdTeam(@Param("inputIdGame") int idGame, @Param("inputIdTeam") int idTeam);

    /**
     * Retrieves a list of distinct team IDs for a specific season based on stats games.
     *
     * @param season The season for which to retrieve distinct team IDs.
     * @return List of distinct team IDs for the specified season.
     */
    @Query(value = "SELECT sp.idTeam FROM StatsPlayer sp LEFT JOIN Game g ON sp.idGame = g.id WHERE g.season=:season GROUP BY (sp.idTeam)", nativeQuery = true)
    List<Integer> findDistinctTeamIds(@Param("season") int season);


    /**
     * Retrieves the sum of various player statistics and average points for a specific player and season.
     *
     * @param idPlayer The ID of the player for which to retrieve stats.
     * @param season   The season for which to retrieve stats.
     * @return List of Object arrays representing the sum of player statistics and average points.
     *         [Sum of FGM, Sum of FGA, Sum of FG%, Sum of FTM, Sum of FTA, Sum of FT%, Sum of TPM, Sum of TPA,
     *         Sum of TP%, Sum of Offensive Rebounds, Sum of Defensive Rebounds, Sum of Total Rebounds,
     *         Sum of Assists, Sum of Personal Fouls, Sum of Steals, Sum of Turnovers, Sum of Blocks,
     *         Sum of Points, Average Points, Total Games Played]
     */
    @Query(value = "SELECT SUM(sp.fgm), SUM(sp.fga), SUM(sp.fgp), SUM(sp.ftm), SUM(sp.fta), SUM(sp.ftp), SUM(sp.tpm), SUM(sp.tpa), SUM(sp.tpp), SUM(sp.offReb)," +
            " SUM(sp.defReb), SUM(sp.totReb), SUM(sp.assists), SUM(sp.pFouls), SUM(sp.steals), SUM(sp.turnovers), SUM(sp.blocks), SUM(sp.points) AS sumPoints, " +
            "AVG(sp.points) AS avgPoints, COUNT(idGame) AS TotGame FROM statsplayer sp LEFT JOIN game g ON sp.idGame=g.id WHERE g.season=:inputSeason AND sp.idPlayer=:inputIdPlayer ", nativeQuery = true)
    List<Object[]> findSumStatsPlayerAndAvgPointsByIdPlayerAndSeason(@Param("inputIdPlayer") int idPlayer, @Param("inputSeason") int season);

    /**
     * Retrieves the ID of the last team a player played for in a specific season.
     *
     * @param idPlayer The ID of the player for which to retrieve the last team.
     * @param season   The season for which to retrieve the last team.
     * @return The ID of the last team the specified player played for in the specified season.
     */
    @Query(value = "SELECT sp.idTeam FROM statsplayer sp left JOIN game g on sp.idGame = g.id where sp.idPlayer=:inputIdPlayer AND g.season=:inputSeason ORDER by g.date DESC LIMIT 1", nativeQuery = true)
    Integer findLastTeamPlayer(@Param("inputIdPlayer") int idPlayer, @Param("inputSeason") int season);

    /**
     * Retrieves the StatsPlayer entity for a specific player and game.
     *
     * @param player The player for which to retrieve stats.
     * @param game   The game for which to retrieve stats.
     * @return The StatsPlayer entity for the specified player and game or null if not found.
     */
    StatsPlayer findByPlayerAndGame(Player player, Game game);

    /**
     * Retrieves the sum of various player statistics for a specific player and season.
     *
     * @param idPlayer The ID of the player for which to retrieve stats.
     * @param season   The season for which to retrieve stats.
     * @return List of Integer arrays representing the sum of player statistics.
     *         [Sum of Points, Sum of Total Rebounds, Sum of Assists, Sum of Field Goals Made,
     *         Sum of Free Throws Made, Sum of Three-Pointers Made]
     */
    @Query(value = "SELECT SUM(sp.points), SUM(sp.totReb), SUM(sp.assists), SUM(sp.fgm),SUM(sp.ftm), SUM(sp.tpm)  FROM statsplayer sp left JOIN game g ON g.id = sp.idGame WHERE idPlayer=:inputIdPlayer AND g.season=:inputSeason", nativeQuery = true)
    List<Integer[]> findSumDataIdPlayerAndSeason(@Param("inputIdPlayer") int idPlayer, @Param("inputSeason") int season);

    /**
     * Retrieves the team ID for a specific player and game.
     *
     * @param idPlayer The ID of the player for which to retrieve the team ID.
     * @param idGame   The ID of the game for which to retrieve the team ID.
     * @return The team ID for the specified player and game.
     */
    @Query(value="SELECT sp.idTeam FROM statsplayer sp WHERE sp.idPlayer=:inputIdPlayer and sp.idGame=:inputIdGame",nativeQuery = true)
    Integer findidTeamByPlayerAndGame(@Param("inputIdPlayer") int idPlayer, @Param("inputIdGame") int idGame);
}
