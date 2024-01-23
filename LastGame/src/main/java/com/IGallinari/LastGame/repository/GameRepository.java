package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.Blog;
import com.IGallinari.LastGame.entity.Game;
import com.IGallinari.LastGame.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * This interface represents the repository for managing Game entities.
 * It extends the JpaRepository interface provided by Spring Data JPA.
 *
 */
@Repository
public interface GameRepository extends JpaRepository<Game,Integer> {

    /**
     * Retrieves all Games objects from the database.
     *
     * @return List of all games in the database.
     */
    @Override
    List<Game> findAll();

    /**
     * Retrieves a Game object by its unique identifier.
     *
     * @param id The unique identifier of the game to be retrieved.
     * @return The Game object with the specified ID or null if not found.
     */
    Game findById(int id);

    /**
     * Retrieves a list of distinct years for which there are games in the database.
     *
     * @return List of distinct years.
     */
    @Query(value = "SELECT  YEAR(date) FROM game GROUP BY YEAR(date)", nativeQuery = true)
    List<Integer> findDistinctYears();


    /**
     * Retrieves a list of game IDs that occurred before a specified date and are not completed (stats not available).
     *
     * @param date The date to compare against.
     * @return List of game IDs that occurred before the specified date and are not completed in statsplayer or statsgames.
     */
    @Query(value = "SELECT id FROM game g WHERE (g.id NOT IN (SELECT sp.idGame FROM statsplayer sp) OR g.id NOT IN (SELECT sg.idGame FROM statsgame sg)) and g.date<:inputDate ORDER BY g.date DESC; ", nativeQuery = true)
    List<Integer> findAllGameIdsBeforeDateNotCompleted(@Param("inputDate") LocalDate date);

    /**
     * Retrieves a list of Games objects for a specified date.
     *
     * @param inputDate The date for which to retrieve games.
     * @return List of Games objects for the specified date.
     */
    List<Game> findGameByDate(LocalDate inputDate);

    /**
     * Retrieves the last four Games objects involving a specific team before a specified date.
     *
     * @param idTeam   The ID of the team for which to retrieve games.
     * @param date     The date to compare against.
     * @return List of the last four Games objects involving the specified team before the specified date.
     */
    @Query(value = "SELECT * FROM game g WHERE (g.idVisitor=:inputIdTeam OR g.idHome=:inputIdTeam) AND g.id IN (SELECT sg.idGame FROM statsgame sg GROUP BY sg.idGame) AND g.date<:inputDate ORDER BY g.date DESC LIMIT 4", nativeQuery = true)
    List<Game> findLastFourGameByTeam(@Param("inputIdTeam")int idTeam,@Param("inputDate")LocalDate date);

    /**
     * Retrieves a list of teams IDs of a specific game.
     * @param idGame The ID of the game for which to retrieve team.
     * @return List of IDs teams involving the specified game.
     */
    @Query(value = "SELECT g.idHome AS idTeam FROM game g WHERE g.id =:idGame UNION SELECT g.idVisitor AS idTeam FROM game g WHERE g.id=:idGame ", nativeQuery = true)
    List<Integer> findIdTeam(@Param("idGame")int idGame);

    /**
     * Returns the last four head-to-head Games objects between two teams, given their IDs and a date.
     *
     * @param idTeamHome ID of the home team
     * @param idTeamVisitor ID of the visiting team
     * @param date the date to search for
     * @return a list of the last four head-to-head games between the two teams
     */
    @Query(value = "SELECT * FROM game g WHERE ((g.idVisitor=:idTeamHome AND g.idHome=:idTeamVisitor) OR (g.idVisitor=:idTeamVisitor AND g.idHome=:idTeamHome)) AND g.id IN (SELECT sg.idGame FROM statsgame sg GROUP BY sg.idGame) AND g.date<:inputDate ORDER BY g.date DESC LIMIT 4;", nativeQuery = true)
    List<Game> findLastFourHtH(@Param("idTeamHome")int idTeamHome,@Param("idTeamVisitor")int idTeamVisitor,@Param("inputDate")LocalDate date);


    /**
     * Returns the next Game object for a given team ID.
     *
     * @param idTeam the ID of the team
     * @return the next Game object for the given team ID
     */
    @Query(value="SELECT * FROM game g WHERE (g.idVisitor=:inputIdTeam OR g.idHome=:inputIdTeam) AND g.status<3 ORDER BY g.date DESC LIMIT 1", nativeQuery = true)
    Game findNextGameByIdTeam(@Param("inputIdTeam") int idTeam);

    /**
     * Returns the most recent past game for a given team ID.
     *
     * @param idTeam the ID of the team
     * @return the most recent past game for the given team ID
     */
    @Query(value="SELECT * FROM game g WHERE (g.idVisitor=:inputIdTeam OR g.idHome=:inputIdTeam) AND g.status=3 ORDER BY g.date ASC LIMIT 1", nativeQuery = true)
    Game findPastGameByIdTeam(@Param("inputIdTeam") int idTeam);

    /**
     * Returns the current season.
     *
     * @return the current season
     */
    @Query(value="SELECT g.season FROM game g WHERE g.status=3 ORDER BY g.date DESC LIMIT 1", nativeQuery = true)
    Integer findCurrentSeason();

}
