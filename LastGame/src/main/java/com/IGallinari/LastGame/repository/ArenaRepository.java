package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.Arena;
import com.IGallinari.LastGame.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArenaRepository extends JpaRepository<Arena,Integer> {
    @Override
    List<Arena> findAll();

    Arena findBynameArena(String nameArena);

    boolean existsBynameArena(String nameArena);
}