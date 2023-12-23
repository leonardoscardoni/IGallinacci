package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.Game;
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

    @Query(value = "SELECT  YEAR(g.date) FROM game AS g GROUP BY YEAR(g.date)", nativeQuery = true)
    List<Integer> findDistinctYears();

    @Query(value = "SELECT  g.id FROM game AS g GROUP BY (g.id)", nativeQuery = true)
    List<Integer> findDistinctIdTeams();

    @Query(value = "SELECT g.id FROM Game g WHERE g.date < :inputDate", nativeQuery = true)
    List<Integer> findAllIdsBeforeDate(@Param("inputDate") LocalDate inputDate);
}
