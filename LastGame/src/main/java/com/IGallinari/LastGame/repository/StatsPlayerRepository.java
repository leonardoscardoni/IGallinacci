package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatsPlayerRepository extends JpaRepository<StatsPlayer,Integer> {

    @Query(value = "SELECT AVG(sp.points),AVG(sp.assists),AVG(sp.totReb),AVG(sp.steals),AVG(sp.blocks) FROM statsplayer sp WHERE idPlayer=:inputIdPlayer", nativeQuery = true)
    List<Float[]> findAvgStatsByIdPlayer(@Param("inputIdPlayer") int idPlayer);
    StatsPlayer findByTeamAndGameAndPlayer(Team team, Game game, Player player);

    List<StatsPlayer> findByTeamAndGame(Team team,Game game);

    @Query(value = "SELECT idPlayer, points FROM statsplayer WHERE idGame = :inputIdGame AND idTeam = :inputIdTeam ORDER BY points DESC LIMIT 1", nativeQuery = true)
    List<Integer[]> findBestPlayerPointsByIdGameAndIdTeam(@Param("inputIdGame") int IdGame, @Param("inputIdTeam") int IdTeam);

    @Query(value = "SELECT idPlayer, totReb FROM statsplayer WHERE idGame = :inputIdGame AND idTeam = :inputIdTeam ORDER BY totReb DESC LIMIT 1", nativeQuery = true)
    List<Integer[]> findBestPlayerTotRebByIdGameAndIdTeam(@Param("inputIdGame") int IdGame, @Param("inputIdTeam") int IdTeam);

    @Query(value = "SELECT idPlayer, assists FROM statsplayer WHERE idGame = :inputIdGame AND idTeam = :inputIdTeam ORDER BY assists DESC LIMIT 1", nativeQuery = true)
    List<Integer[]> findBestPlayerAssistByIdGameAndIdTeam(@Param("inputIdGame") int IdGame, @Param("inputIdTeam") int IdTeam);

    @Query(value = "SELECT sp.idTeam FROM StatsPlayer sp LEFT JOIN Game g ON sp.idGame = g.id WHERE g.season=:season GROUP BY (sp.idTeam)", nativeQuery = true)
    List<Integer> findDistinctTeamIds(@Param("season") Integer season);


    @Query(value = "SELECT DISTINCT g.season FROM StatsPlayer sp LEFT JOIN Game g ON sp.idGame = g.id", nativeQuery = true)
    List<Integer> findDistinctSeason();
}