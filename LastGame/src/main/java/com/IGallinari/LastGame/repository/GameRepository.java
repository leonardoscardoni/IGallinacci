package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.Game;
import com.IGallinari.LastGame.entity.Team;
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

    @Query(value = "SELECT  YEAR(date) FROM game GROUP BY YEAR(date)", nativeQuery = true)
    List<Integer> findDistinctYears();

    @Query(value = "SELECT  id FROM game GROUP BY (id)", nativeQuery = true)
    List<Integer> findDistinctIdTeams();

    @Query(value = "SELECT g.id FROM Game AS g WHERE g.date <:inputDate ORDER BY g.date DESC; ", nativeQuery = true)
    List<Integer> findAllGameIdsBeforeDate(@Param("inputDate") LocalDate inputDate);

    @Query(value = "SELECT g.id FROM game g WHERE (g.id NOT IN(SELECT sp.idGame FROM statsplayer sp GROUP BY sp.idGame) OR g.id NOT IN(SELECT sg.idGame FROM statsgame sg GROUP BY sg.idGame)) AND g.status=3 AND g.season=:inputDate ", nativeQuery = true)
    List<Integer> findAllGameIdsBeforeDateNotCompleted(@Param("inputDate") LocalDate inputDate);

    List<Game> findGameByDate(LocalDate inputDate);

    @Query(value = "SELECT * FROM game g WHERE (g.idVisitor=:inputIdTeam OR g.idHome=:inputIdTeam) AND g.id IN (SELECT sg.idGame FROM statsgame sg GROUP BY sg.idGame) AND g.date<:inputDate ORDER BY g.date DESC LIMIT 4", nativeQuery = true)
    List<Game> findLastFourGameByTeam(@Param("inputIdTeam")int idTeam,@Param("inputDate")LocalDate date);

    @Query(value = "SELECT g.idHome AS idTeam FROM game g WHERE g.id =:idGame UNION SELECT g.idVisitor AS idTeam FROM game g WHERE g.id=:idGame ", nativeQuery = true)
    List<Integer> findIdTeam(@Param("idGame")int idGame);

    @Query(value = "SELECT * FROM game g WHERE ((g.idVisitor=:idTeamHome AND g.idHome=:idTeamVisitor) OR (g.idVisitor=:idTeamVisitor AND g.idHome=:idTeamHome)) AND g.id IN (SELECT sg.idGame FROM statsgame sg GROUP BY sg.idGame) AND g.date<:inputDate ORDER BY g.date DESC LIMIT 4;", nativeQuery = true)
    List<Game> findLastFourHtH(@Param("idTeamHome")int idTeamHome,@Param("idTeamVisitor")int idTeamVisitor,@Param("inputDate")LocalDate date);

    @Query(value = "SELECT idHome AS TeamID FROM game WHERE date =:inputDate UNION SELECT idVisitor AS TeamID FROM game WHERE date =:inputDate; ", nativeQuery = true)
    List<Integer> findIdTeamFromDate(@Param("inputDate")LocalDate inputDate);
}
