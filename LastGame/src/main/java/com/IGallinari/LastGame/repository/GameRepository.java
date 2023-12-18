package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game,Integer> {
    @Override
    List<Game> findAll();

    Game findById(int id);

    @Query(value = "SELECT  YEAR(game_date) FROM game GROUP BY YEAR(game_date)", nativeQuery = true)
    List<Integer> findDistinctYears();

    @Query(value = "SELECT  g.id FROM game AS g GROUP BY (g.id)", nativeQuery = true)
    List<Integer> findDistinctIdTeams();

    @Query(value = "SELECT g.id FROM Game g", nativeQuery = true)
    List<Integer> findAllIds();
}
