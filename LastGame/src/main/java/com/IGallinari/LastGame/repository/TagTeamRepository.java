package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.Blog;
import com.IGallinari.LastGame.entity.Paragraph;
import com.IGallinari.LastGame.entity.TagTeam;
import com.IGallinari.LastGame.entity.id_class.IdParagraph;
import com.IGallinari.LastGame.entity.id_class.IdTagTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This interface represents the repository for managing TagTeam entities.
 * It extends the JpaRepository interface provided by Spring Data JPA.
 *
 */
@Repository
public interface TagTeamRepository extends JpaRepository<TagTeam, IdTagTeam> {

    /**
     * Retrieves a list of team IDs associated with a specific blog.
     *
     * @param idBlog The ID of the blog for which to retrieve team IDs.
     * @return List of team IDs associated with the specified blog.
     */
    @Query(value = "SELECT tt.idTeam FROM tagTeam tt WHERE tt.idBlog=:inputIdBlog", nativeQuery = true)
    List<Integer> findTagTeamByIdBlog(@Param("inputIdBlog") int idBlog);
}
