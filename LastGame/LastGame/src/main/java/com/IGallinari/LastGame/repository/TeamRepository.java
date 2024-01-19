package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team,Integer> {
    @Override
    List<Team> findAll();

    Team findById(int id);

    @Query(value = "SELECT DISTINCT t.id FROM Team t", nativeQuery = true)
    List<Integer> findAllIds();

    @Query(value="SELECT s.win FROM game g JOIN team t ON g.idVisitor = t.id JOIN statsgame s ON g.id = s.idGame WHERE t.id =:idTeam AND g.date < CURDATE() ORDER BY g.date DESC LIMIT 4;", nativeQuery = true)
    List<Integer> findLast4gameswinloss(@Param("idTeam")int idTeam);

    List<Team> findByDivision(String division);

    Boolean existsById(int id);
}
