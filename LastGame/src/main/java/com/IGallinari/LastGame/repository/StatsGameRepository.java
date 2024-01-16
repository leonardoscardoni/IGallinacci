package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.Game;
import com.IGallinari.LastGame.entity.StatsGame;
import com.IGallinari.LastGame.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatsGameRepository extends JpaRepository<StatsGame,Integer> {

    StatsGame findByTeamAndGame(Team team, Game game);

    @Query(value = "SELECT DISTINCT sg.idGame FROM Statsgame sg", nativeQuery = true)
    List<Integer> findAllIds();
    @Query(value = "SELECT sg.idGame FROM statsgame sg WHERE sg.fgm IS NULL GROUP BY sg.idGame; ", nativeQuery = true)
    List<Integer> findAllIdsWhereIsNotComplete();
    StatsGame findStatsGameByGameAndTeam(Game inputGame,Team inputTeam);
    @Query(value = "SELECT AVG(sg.points) FROM statsgame sg WHERE sg.idGame IN (SELECT g.id FROM game g WHERE g.idVisitor =:inputIdTeam OR g.idHome =:inputIdTeam) AND sg.idTeam !=:inputIdTeam", nativeQuery = true)
    Integer findAllowedPoints(@Param("inputIdTeam") int inputIdTeam);

    @Query(value = "SELECT AVG(sg.points) FROM statsgame sg WHERE sg.idTeam =:inputIdTeam", nativeQuery = true)
    Integer findPointsPerGame(@Param("inputIdTeam") int inputIdTeam);
}