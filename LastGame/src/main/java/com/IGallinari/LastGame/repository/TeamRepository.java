package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This interface represents the repository for managing Team entities.
 * It extends the JpaRepository interface provided by Spring Data JPA.
 *
 * @author Your Name
 * @version 1.0
 * @since 2024-01-23
 */
@Repository
public interface TeamRepository extends JpaRepository<Team,Integer> {

    /**
     * Retrieves a list of all teams.
     *
     * @return List of all teams.
     */
    @Override
    List<Team> findAll();

    /**
     * Retrieves a team by its unique identifier.
     *
     * @param id The unique identifier of the team.
     * @return The Team objects for the specified ID or null if not found.
     */
    Team findById(int id);

    /**
     * Retrieves a list of all unique team IDs.
     *
     * @return List of all unique team IDs.
     */
    @Query(value = "SELECT DISTINCT t.id FROM Team t", nativeQuery = true)
    List<Integer> findAllIds();

    /**
     * Retrieves a list of teams by division.
     *
     * @param division The division for which to retrieve teams.
     * @return List of Teams objects in the specified division.
     */
    List<Team> findByDivision(String division);

    /**
     * Retrieves a list of teams by conference.
     *
     * @param conference The conference for which to retrieve teams.
     * @return List of Teams objects in the specified conference.
     */
    List<Team> findByConference(String conference);

}
