package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.FavPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FavPlayerRepository  extends JpaRepository<FavPlayer,Integer> {
    @Query(value = "SELECT fp.idPlayer FROM favplayer fp WHERE fp.idUser=:inputIdUser", nativeQuery = true)
    List<Integer> findFavPlayersByUser(@Param("inputIdUser") int idUser);
}
