package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface represents the repository for managing User entities.
 * It extends the JpaRepository interface provided by Spring Data JPA.
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    /**
     * Retrieves a user by its unique identifier.
     *
     * @param idUser The unique identifier of the user.
     * @return The User object for the specified ID or null if not found.
     */
    User findById(int idUser);

    /**
     * Retrieves a user by their email address.
     *
     * @param email The email address of the user.
     * @return The User object for the specified email or null if not found.
     */
    User findByEmail(String email);

    /**
     * Checks if a user exists by their email address.
     *
     * @param email The email address to check.
     * @return True if the user exists, false otherwise.
     */
    boolean existsByEmail(String email);
}
