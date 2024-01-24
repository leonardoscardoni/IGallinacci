package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.FavPlayer;
import com.IGallinari.LastGame.entity.Player;
import com.IGallinari.LastGame.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This interface represents the repository for managing FavPlayer entities.
 * It extends the JpaRepository interface provided by Spring Data JPA.
 *
 */
@Repository
public interface FavPlayerRepository  extends JpaRepository<FavPlayer,Integer> {

    /**
     * Retrieves a FavPlayer object by user and player.
     *
     * @param user   The user associated with the FavPlayer.
     * @param player The player associated with the FavPlayer.
     * @return The FavPlayer object with the specified user and player or null if not found.
     */
    FavPlayer findByUserAndPlayer(User user, Player player);

    /**
     * Retrieves a list of player IDs marked as favorite by a user.
     *
     * @param idUser The ID of the user for whom to retrieve favorite player IDs.
     * @return List of player IDs marked as favorite by the user.
     */
    @Query(value = "SELECT fp.idPlayer FROM favplayer fp WHERE fp.idUser=:inputIdUser", nativeQuery = true)
    List<Integer> findFavPlayersByUser(@Param("inputIdUser") int idUser);

    /**
     * Checks if a record with the specified user ID and player ID exists in the database.
     *
     * @param idUser   The ID of the user.
     * @param idPlayer The ID of the player.
     * @return 1 if the record exists, 0 otherwise.
     */
    @Query(value = "SELECT EXISTS(SELECT 1 FROM favplayer WHERE idUser = :inputIdUser AND idPlayer = :inputIdPlayer)", nativeQuery = true)
    int existsByIdUserAndIdPlayer(@Param("inputIdUser") int idUser, @Param("inputIdPlayer") int idPlayer);
}
