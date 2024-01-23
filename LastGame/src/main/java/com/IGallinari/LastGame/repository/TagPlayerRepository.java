package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.TagPlayer;
import com.IGallinari.LastGame.entity.id_class.IdTagPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagPlayerRepository extends JpaRepository<TagPlayer, IdTagPlayer> {

    @Query(value = "SELECT tp.idPlayer FROM tagplayer tp WHERE tp.idBlog=:inputIdBlog", nativeQuery = true)
    List<Integer> findTagPlayerByIdBlog(@Param("inputIdBlog") int idBlog);
}
