package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.Arena;
import com.IGallinari.LastGame.entity.PlayerTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerTeamRepository extends JpaRepository<PlayerTeam,Integer> {

    @Query(value ="SELECT DISTINCT pt.idTeam FROM playerteam AS pt WHERE season LIKE :inputSeason GROUP BY  idTeam",  nativeQuery = true)
    List<Integer> findDistinctIdTeams(@Param("inputSeason") Integer inputSeason);
}
