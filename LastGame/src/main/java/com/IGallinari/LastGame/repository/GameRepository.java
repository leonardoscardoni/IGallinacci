package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.Game;
import com.IGallinari.LastGame.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game,Integer> {
    @Override
    List<Game> findAll();

    Game findById(int id);
}
