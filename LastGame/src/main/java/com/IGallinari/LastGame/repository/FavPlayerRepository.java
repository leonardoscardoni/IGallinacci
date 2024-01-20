package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.FavPlayer;
import com.IGallinari.LastGame.entity.Player;
import com.IGallinari.LastGame.entity.User;
import com.IGallinari.LastGame.entity.id_class.IdFavPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FavPlayerRepository  extends JpaRepository<FavPlayer, IdFavPlayer> {

    FavPlayer findByUserAndPlayer(User user, Player player);
    @Query(value = "SELECT fp.idPlayer FROM favplayer fp WHERE fp.idUser=:inputIdUser", nativeQuery = true)
    List<Integer> findFavPlayersByUser(@Param("inputIdUser") int idUser);

    @Query(value = "SELECT EXISTS(SELECT 1 FROM favplayer WHERE idUser = :inputIdUser AND idPlayer = :inputIdPlayer)", nativeQuery = true)
    int existsByIdUserAndIdPlayer(@Param("inputIdUser") int idUser, @Param("inputIdPlayer") int idPlayer);
}
