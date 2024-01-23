package com.IGallinari.LastGame.repository;


import com.IGallinari.LastGame.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This interface represents the repository for managing Blog entities.
 * It extends the JpaRepository interface provided by Spring Data JPA.
 *
 */
@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {

    /**
     * Retrieves a Blog object by its unique identifier.
     *
     * @param id The unique identifier of the blog to be retrieved.
     * @return The Blog object with the specified ID or null if not found.
     */
    Blog findBlogById(int id);

    /**
     * Retrieves the last four Blog objects ordered by date in descending order.
     *
     * @return List of the last four Blog objects.
     */
    @Query(value = "SELECT * FROM blog b ORDER BY b.date DESC LIMIT 4;", nativeQuery = true)
    List<Blog> findLastFourBlogs();

    /**
     * Retrieves all Blog objects from the database.
     *
     * @return List of all Blog objects in the database.
     */
    List<Blog> findAll();

}
