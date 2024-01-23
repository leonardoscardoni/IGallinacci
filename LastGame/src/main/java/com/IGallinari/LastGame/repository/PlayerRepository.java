package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.Game;
import com.IGallinari.LastGame.entity.Player;
import com.IGallinari.LastGame.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.BitSet;
import java.util.List;

/**
 * This interface represents the repository for managing Player entities.
 * It extends the JpaRepository interface provided by Spring Data JPA.
 *
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer> {

    /**
     * Retrieves all Players objects from the database.
     *
     * @return List of all Players objects in the database.
     */
    @Override
    List<Player> findAll();

    /**
     * Retrieves a Player object by its unique identifier.
     *
     * @param id The unique identifier of the player to be retrieved.
     * @return The Player object with the specified ID or null if not found.
     */
    Player findById(int id);

    /**
     * Checks if a player with the specified ID exists in the database.
     *
     * @param id The ID of the player to check for existence.
     * @return true if a player with the specified ID exists, false otherwise.
     */
    boolean existsById(int id);

    /**
     * Retrieves a list of distinct player positions (codes) from the database.
     *
     * @return List of distinct player positions.
     */
    @Query(value="SELECT pos FROM player GROUP BY pos;", nativeQuery = true)
    List<String> findRoles();

}