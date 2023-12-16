package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.Game;
import com.IGallinari.LastGame.entity.Standing;
import com.IGallinari.LastGame.entity.StatsGame;
import com.IGallinari.LastGame.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandingRepository extends JpaRepository<Standing,Integer> {

    Standing findByTeamAndSeason(Team team, int season);

}
