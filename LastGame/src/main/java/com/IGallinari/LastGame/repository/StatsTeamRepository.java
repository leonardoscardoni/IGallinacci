package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatsTeamRepository extends JpaRepository<StatsTeam,Integer> {

    StatsTeam findByTeamAndSeason(Team team,int season);

    @Query(value = "SELECT st.idTeam FROM StatsTeam st WHERE st.season=:season GROUP BY st.idTeam", nativeQuery = true)
    List<Integer> findDistinctTeamIds(@Param("season") Integer season);

    @Query(value = "SELECT st.season FROM StatsTeam st WHERE st.rankConference IS NOT NULL GROUP BY st.idTeam; ", nativeQuery = true)
    List<Integer> findDistincSeasonsWhereIsNotComplete();


}