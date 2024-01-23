package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.TagPlayer;
import com.IGallinari.LastGame.entity.id_class.IdTagPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This interface represents the repository for managing TagPlayer entities.
 * It extends the JpaRepository interface provided by Spring Data JPA.
 *
 */
@Repository
public interface TagPlayerRepository extends JpaRepository<TagPlayer, IdTagPlayer> {

    /**
     * Retrieves a list of player IDs associated with a specific blog.
     *
     * @param idBlog The ID of the blog for which to retrieve player IDs.
     * @return List of player IDs associated with the specified blog.
     */
    @Query(value = "SELECT tp.idPlayer FROM tagplayer tp WHERE tp.idBlog=:inputIdBlog", nativeQuery = true)
    List<Integer> findTagPlayerByIdBlog(@Param("inputIdBlog") int idBlog);
}
