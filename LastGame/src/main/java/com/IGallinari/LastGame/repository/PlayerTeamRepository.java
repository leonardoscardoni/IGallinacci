package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.PlayerTeam;
import com.IGallinari.LastGame.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This interface represents the repository for managing PlayerTeam entities.
 * It extends the JpaRepository interface provided by Spring Data JPA.
 *
 */
@Repository
public interface PlayerTeamRepository extends JpaRepository<PlayerTeam, Integer> {

    /**
     * Retrieves a list of PlayerTeams objects for a specific team and season.
     *
     * @param team   The team for which to retrieve player teams.
     * @param season The season for which to retrieve player teams.
     * @return List of PlayerTeams objects for the specified team and season.
     */
    List<PlayerTeam> findByTeamAndSeason(Team team, int season);

    /**
     * Retrieves a list of distinct team IDs for a specific season.
     *
     * @param season The season for which to retrieve distinct team IDs.
     * @return List of distinct team IDs for the specified season.
     */
    @Query(value = "SELECT DISTINCT pt.idTeam FROM playerteam AS pt WHERE season LIKE :inputSeason GROUP BY idTeam", nativeQuery = true)
    List<Integer> findDistinctIdTeams(@Param("inputSeason") Integer season);

}
