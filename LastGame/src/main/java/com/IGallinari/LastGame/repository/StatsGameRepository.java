package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.Game;
import com.IGallinari.LastGame.entity.StatsGame;
import com.IGallinari.LastGame.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StatsGameRepository extends JpaRepository<StatsGame,Integer> {

    StatsGame findByTeamAndGame(Team team, Game game);

    List<StatsGame> findStatsGameByGameDate(LocalDate inputDate);

    @Query(value = "SELECT sg.idGame FROM statsgame sg WHERE sg.fastBreakPoint IS NOT NULL;", nativeQuery = true)
    List<Integer> findAllIdsWhereIsNotComplete();

}