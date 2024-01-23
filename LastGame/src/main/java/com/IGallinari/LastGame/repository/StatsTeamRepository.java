package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This interface represents the repository for managing StatsTeam entities.
 * It extends the JpaRepository interface provided by Spring Data JPA.
 *
 */
@Repository
public interface StatsTeamRepository extends JpaRepository<StatsTeam,Integer> {

    /**
     * Retrieves the StatsTeam entity for a specific team and season.
     *
     * @param team   The team for which to retrieve stats.
     * @param season The season for which to retrieve stats.
     * @return The StatsTeam entity for the specified team and season or null if not found.
     */
    StatsTeam findByTeamAndSeason(Team team, int season);

    /**
     * Retrieves the team statistics for a specific team and season.
     *
     * @param idTeam  The ID of the team for which to retrieve stats.
     * @param season  The season for which to retrieve stats.
     * @return List of Integer arrays representing the team statistics.
     *         [Points, Total Rebounds, Assists, Field Goals Made, Free Throws Made, Three-Pointers Made]
     */
    @Query(value = "SELECT st.points, st.totReb, st.assists, st.fgm,st.ftm,st.tpm  FROM statsteam st WHERE idTeam=:inputIdTeam AND season=:inputSeason", nativeQuery = true)
    List<Integer[]> findDataTeamByIdTeamAndSeason(@Param("inputIdTeam") int idTeam ,@Param("inputSeason") int season);

    /**
     * Retrieves the average team statistics for all teams except a specific team in a given season.
     *
     * @param idTeam  The ID of the team to exclude from the average calculation.
     * @param season  The season for which to calculate average team statistics.
     * @return List of Float arrays representing the average team statistics.
     *         [Average Points, Average Total Rebounds, Average Assists, Average Field Goals Made,
     *         Average Free Throws Made, Average Three-Pointers Made]
     */
    @Query(value = "SELECT AVG(st.points), AVG(st.totReb), AVG(st.assists), AVG(st.fgm), AVG(st.ftm) ,AVG(st.tpm)  FROM statsteam st WHERE idTeam!=:inputIdTeam AND season=:inputSeason", nativeQuery = true)
    List<Float[]> findDataAvgNba(@Param("inputIdTeam") int idTeam ,@Param("inputSeason") int season);

    /**
     * Retrieves a list of distinct team IDs for a specific season.
     *
     * @param season The season for which to retrieve distinct team IDs.
     * @return List of distinct team IDs for the specified season.
     */
    @Query(value = "SELECT st.idTeam FROM StatsTeam st WHERE st.season=:season GROUP BY st.idTeam", nativeQuery = true)
    List<Integer> findDistinctTeamIds(@Param("season") Integer season);

    /**
     * Retrieves a list of distinct seasons where team rankings are not complete.
     *
     * @return List of distinct seasons where team rankings are not complete.
     */
    @Query(value = "SELECT st.season FROM StatsTeam st WHERE st.rankConference IS NOT NULL GROUP BY st.idTeam; ", nativeQuery = true)
    List<Integer> findDistincSeasonsWhereIsNotComplete();
}