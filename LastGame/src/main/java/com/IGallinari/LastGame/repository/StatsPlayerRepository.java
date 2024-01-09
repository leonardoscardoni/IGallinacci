package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.*;
import com.IGallinari.LastGame.payload.response.TeamDetails.ViewStatsPlayerTeamDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface StatsPlayerRepository extends JpaRepository<StatsPlayer,Integer> {

    @Query(value = "SELECT AVG(sp.points),AVG(sp.assists),AVG(sp.totReb),AVG(sp.steals),AVG(sp.blocks) FROM statsplayer sp WHERE idPlayer=:inputIdPlayer", nativeQuery = true)
    List<Float[]> findAvgStatsByIdPlayer(@Param("inputIdPlayer") int idPlayer);
    StatsPlayer findByTeamAndGameAndPlayer(Team team, Game game, Player player);

    @Query(value = "SELECT sp.idTeam FROM StatsPlayer sp LEFT JOIN Game g ON sp.idGame = g.id WHERE g.season=:season GROUP BY (sp.idTeam)", nativeQuery = true)
    List<Integer> findDistinctTeamIds(@Param("season") Integer season);


    @Query(value = "SELECT DISTINCT g.season FROM StatsPlayer sp LEFT JOIN Game g ON sp.idGame = g.id", nativeQuery = true)
    List<Integer> findDistinctSeason();
}