package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatsPlayerRepository extends JpaRepository<StatsPlayer,Integer> {

    StatsPlayer findByTeamAndGameAndPlayer(Team team, Game game, Player player);

    @Query(value = "SELECT sp.idTeam FROM StatsPlayer sp LEFT JOIN Game g ON sp.idGame = g.id WHERE g.season=:season GROUP BY (sp.idTeam)", nativeQuery = true)
    List<Integer> findDistinctTeamIds(@Param("season") Integer season);


    @Query(value = "SELECT DISTINCT g.season FROM StatsPlayer sp LEFT JOIN Game g ON sp.idGame = g.id", nativeQuery = true)
    List<Integer> findDistinctSeason();
}