package com.IGallinari.LastGame.repository;


import com.IGallinari.LastGame.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {

    Blog findBlogById(int id);
    @Query(value = "SELECT * FROM blog b ORDER BY b.date LIMIT 4;", nativeQuery = true)
    List<Blog> findLastFourBlogs();

}
