package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.Game;
import com.IGallinari.LastGame.entity.StatsGame;
import com.IGallinari.LastGame.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatsGameRepository extends JpaRepository<StatsGame,Integer> {

    StatsGame findByTeamAndGame(Team team, Game game);

    @Query(value = "SELECT DISTINCT sg.idGame FROM Statsgame sg", nativeQuery = true)
    List<Integer> findAllIds();
    @Query(value = "SELECT sg.idGame FROM statsgame sg WHERE sg.fastBreakPoint IS NOT NULL;", nativeQuery = true)
    List<Integer> findAllIdsWhereIsNotComplete();


    StatsGame findStatsGameByGameAndTeam(Game inputGame,Team inputTeam);
}