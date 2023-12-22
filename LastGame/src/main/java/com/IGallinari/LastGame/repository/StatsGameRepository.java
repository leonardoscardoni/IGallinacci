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

    List<StatsGame> findStatsGameByGameGameDate(LocalDate inputDate);

    @Query(value = "SELECT DISTINCT sg.idGame FROM Statsgame sg", nativeQuery = true)
    List<Integer> findAllIds();

}