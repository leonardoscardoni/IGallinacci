package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.Arena;
import com.IGallinari.LastGame.entity.PlayerTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerTeamRepository extends JpaRepository<PlayerTeam,Integer> {

    @Query(value ="SELECT DISTINCT pt.idTeam FROM playerteam AS pt",  nativeQuery = true)
    List<Integer> findDistinctIdTeams();
}
