package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.FavTeam;

import com.IGallinari.LastGame.entity.Team;
import com.IGallinari.LastGame.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This interface represents the repository for managing FavTeam entities.
 * It extends the JpaRepository interface provided by Spring Data JPA.
 *
 */
@Repository
public interface FavTeamRepository extends JpaRepository<FavTeam,Integer> {

    /**
     * Retrieves a FavTeam object by User and Team.
     *
     * @param user The user associated with the FavTeam.
     * @param team The team associated with the FavTeam.
     * @return The FavTeam object with the specified user and team or null if not found.
     */
    FavTeam findByUserAndTeam(User user, Team team);

    /**
     * Retrieves a list of team IDs marked as favorite by a user.
     *
     * @param idUser The ID of the user for whom to retrieve favorite team IDs.
     * @return List of team IDs marked as favorite by the user.
     */
    @Query(value = "SELECT ft.idTeam FROM favteam ft WHERE ft.idUser=:inputIdUser", nativeQuery = true)
    List<Integer> findFavTeamsByUser(@Param("inputIdUser") int idUser);

    /**
     * Checks if a record with the specified user ID and team ID exists in the database.
     *
     * @param idUser The ID of the user.
     * @param idTeam The ID of the team.
     * @return 1 if the record exists, 0 otherwise.
     */
    @Query(value = "SELECT EXISTS(SELECT 1 FROM favteam WHERE idUser = :inputIdUser AND idTeam = :inputIdTeam)", nativeQuery = true)
    int existsByIdUserAndIdTeam(@Param("inputIdUser") int idUser, @Param("inputIdTeam") int idTeam);
}
