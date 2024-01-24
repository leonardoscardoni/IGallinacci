package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.Game;
import com.IGallinari.LastGame.entity.StatsGame;
import com.IGallinari.LastGame.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This interface represents the repository for managing StatsGame entities.
 * It extends the JpaRepository interface provided by Spring Data JPA.
 *
 */
@Repository
public interface StatsGameRepository extends JpaRepository<StatsGame,Integer> {

    /**
     * Retrieves the StatsGame object for a specific team and game.
     *
     * @param team The team for which to retrieve stats.
     * @param game The game for which to retrieve stats.
     * @return The StatsGame object for the specified team and game or null if not found.
     */
    StatsGame findByTeamAndGame(Team team, Game game);


    /**
     * Retrieves a list of game IDs where stats are not complete (some fields are null).
     *
     * @return List of game IDs where stats are not complete.
     */
    @Query(value = "SELECT sg.idGame FROM statsgame sg WHERE sg.fgm IS NULL GROUP BY sg.idGame DESC; ", nativeQuery = true)
    List<Integer> findAllIdsWhereIsNotComplete();

    /**
     * Retrieves the StatsGames object for a specific game and team.
     *
     * @param game The game for which to retrieve stats.
     * @param team The team for which to retrieve stats.
     * @return The StatsGame object for the specified game and team or null if not found.
     */
    StatsGame findStatsGameByGameAndTeam(Game game,Team team);

    /**
     * Calculates the average points allowed by a team in games of a specific season where they were not the specified team.
     *
     * @param idTeam   The ID of the team for which to calculate average allowed points.
     * @param season   The season for which to calculate average allowed points.
     * @return The average points allowed by the specified team in games of the specified season.
     */
    @Query(value = "SELECT AVG(sg.points) FROM statsgame sg WHERE sg.idGame IN (SELECT g.id FROM game g WHERE (g.idVisitor =:inputIdTeam OR g.idHome =:inputIdTeam) AND g.season=:inputSeason ) AND sg.idTeam !=:inputIdTeam", nativeQuery = true)
    Float findAllowedPoints(@Param("inputIdTeam") int idTeam,@Param("inputSeason") int season);

    /**
     * Calculates the average points scored per game by a team in games of a specific season.
     *
     * @param idTeam   The ID of the team for which to calculate average points per game.
     * @param season   The season for which to calculate average points per game.
     * @return The average points scored per game by the specified team in games of the specified season.
     */
    @Query(value = "SELECT AVG(sg.points) FROM statsgame sg LEFT JOIN game g on sg.idGame=g.id WHERE sg.idTeam =:inputIdTeam AND g.season=:inputSeason ", nativeQuery = true)
    Float findPointsPerGame(@Param("inputIdTeam") int idTeam, @Param("inputSeason") int season);

}