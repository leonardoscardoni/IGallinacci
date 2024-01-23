package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.Arena;
import com.IGallinari.LastGame.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This interface represents the repository for managing Arena entities.
 * It extends the JpaRepository interface provided by Spring Data JPA.
 *
 */

@Repository
public interface ArenaRepository extends JpaRepository<Arena,Integer> {
    /**
     * Retrieves all Arenas from the database.
     *
     * @return List of all Arenas objects in the database.
     */
    @Override
    List<Arena> findAll();

    /**
     * Retrieves an Arena by its name.
     *
     * @param name The name of the arena to be retrieved.
     * @return The Arena object with the specified name or null if not found.
     */
    Arena findByName(String name);

    /**
     * Checks if an Arena with the specified name exists in the database.
     *
     * @param name The name of the arena to check for existence.
     * @return true if an arena with the specified name exists, false otherwise.
     */
    boolean existsByName(String name);
}