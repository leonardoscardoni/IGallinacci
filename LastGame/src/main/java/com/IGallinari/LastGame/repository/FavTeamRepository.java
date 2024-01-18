package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.FavTeam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavTeamRepository extends JpaRepository<FavTeam,Integer> {

    @Query(value = "SELECT ft.idTeam FROM favteam ft WHERE ft.idUser=:inputIdUser", nativeQuery = true)
    List<Integer> findFavTeamsByUser(@Param("inputIdUser") int idUser);

    @Query(value = "SELECT EXISTS(SELECT 1 FROM favteam WHERE idUser = :inputIdUser AND idTeam = :inputIdTeam)", nativeQuery = true)
    boolean existsByIdUserAndIdTeam(@Param("inputIdUser") int idUser, @Param("inputIdTeam") int idTeam);
}
