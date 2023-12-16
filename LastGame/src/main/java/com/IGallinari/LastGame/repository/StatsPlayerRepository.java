package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatsPlayerRepository extends JpaRepository<StatsPlayer,Integer> {

    StatsPlayer findByTeamAndGameAndPlayer(Team team, Game game, Player player);

}