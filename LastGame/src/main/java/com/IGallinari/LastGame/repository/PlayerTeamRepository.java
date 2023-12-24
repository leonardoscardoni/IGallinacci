package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.Arena;
import com.IGallinari.LastGame.entity.PlayerTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerTeamRepository extends JpaRepository<PlayerTeam,Integer> {
}
