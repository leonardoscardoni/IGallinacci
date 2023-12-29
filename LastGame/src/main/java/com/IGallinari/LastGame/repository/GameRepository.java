package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.Game;
import com.IGallinari.LastGame.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game,Integer> {
    @Override
    List<Game> findAll();

    Game findById(int id);

    @Query(value = "SELECT  YEAR(date) FROM game GROUP BY YEAR(date)", nativeQuery = true)
    List<Integer> findDistinctYears();

    @Query(value = "SELECT  id FROM game GROUP BY (id)", nativeQuery = true)
    List<Integer> findDistinctIdTeams();

    @Query(value = "SELECT g.id,g.date FROM Game AS g WHERE g.date <:inputDate ORDER BY g.date DESC; ", nativeQuery = true)
    List<Integer> findAllIdsBeforeDate(@Param("inputDate") LocalDate inputDate);

    List<Game> findGameByDate(LocalDate inputDate);

    @Query(value = "SELECT * FROM game g WHERE g.idVisitor=:idTeam OR g.idHome=:idTeam LIMIT 4;", nativeQuery = true)
    List<Game> findLastFourGameByTeam(@Param("idTeam")int idTeam);

    @Query(value = "SELECT * FROM game g WHERE (g.idVisitor=:idTeamHome AND g.idHome=:idTeamVisitor) OR (g.idVisitor=:idTeamVisitor AND g.idHome=:idTeamHome) LIMIT 4;", nativeQuery = true)
    List<Game> findLastFourHtH(@Param("idTeamHome")int idTeamHome,@Param("idTeamVisitor")int idTeamVisitor);
}
