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
    List<Integer> findDistinctTeamIds(@Param("season") int season);

    @Query(value = "SELECT SUM(sp.fgm), SUM(sp.fga), SUM(sp.fgp), SUM(sp.ftm), SUM(sp.fta), SUM(sp.ftp), SUM(sp.tpm), SUM(sp.tpa), SUM(sp.tpp), SUM(sp.offReb)," +
            " SUM(sp.defReb), SUM(sp.totReb), SUM(sp.assists), SUM(sp.pFouls), SUM(sp.steals), SUM(sp.turnovers), SUM(sp.blocks), SUM(sp.points) AS sumPoints, " +
            "AVG(sp.points) AS avgPoints, COUNT(idGame) AS TotGame FROM statsplayer sp LEFT JOIN game g ON sp.idGame=g.id WHERE g.season=:inputSeason AND sp.idPlayer=:inputIdPlayer ", nativeQuery = true)
    List<Object[]> findSumStatsPlayerAndAvgPointsByIdPlayerAndSeason(@Param("inputIdPlayer") int idPlayer, @Param("inputSeason") int season);

    @Query(value = "SELECT DISTINCT g.season FROM StatsPlayer sp LEFT JOIN Game g ON sp.idGame = g.id", nativeQuery = true)
    List<Integer> findDistinctSeason();

    @Query(value = "SELECT AVG(st.points) FROM StatsPlayer st LEFT JOIN game g ON st.idGame = g.id WHERE st.idPlayer = :inputIdPlayer AND g.season = :inputSeason", nativeQuery = true)
    Float findAvgPointsByIdPlayerAndSeason(@Param("inputIdPlayer") int idPlayer, @Param("inputSeason") int season);


    @Query(value = "SELECT SUM(st.points)FROM StatsPlayer st LEFT JOIN game g ON st.idGame = g.id WHERE st.idPlayer = 40 AND g.season = 2023;", nativeQuery = true)
    Float findSumPointsByIdPlayerAndSeason(@Param("inputIdPlayer")int idPlayer, @Param("inputSeason")int season);

    @Query(value = "SELECT sp.idTeam FROM statsplayer sp left JOIN game g on sp.idGame = g.id where sp.idPlayer=:inputIdPlayer AND g.season=:inputSeason ORDER by g.date DESC LIMIT 1")
    Integer findLastTeamPlayer(@Param("inputIdPlayer") int idPlayer, @Param("inputSeason") int season);

    StatsPlayer findByPlayerAndGame(Player player, Game game);

    @Query(value = "SELECT SUM(sp.points), SUM(sp.totReb), SUM(sp.assists), SUM(sp.fgm),SUM(sp.ftm), SUM(sp.tpm)  FROM statsplayer sp left JOIN game g ON g.id = sp.idGame WHERE idPlayer=:inputIdPlayer AND g.season=:inputSeason", nativeQuery = true)
    List<Integer[]> findSumDataIdPlayerAndSeason(@Param("inputIdPlayer") int idPlayer, @Param("inputSeason") int season);
}
