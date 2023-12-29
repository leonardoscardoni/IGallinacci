package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team,Integer> {
    @Override
    List<Team> findAll();

    Team findById(int id);

    @Query(value = "SELECT DISTINCT t.id FROM Team t", nativeQuery = true)
    List<Integer> findAllIds();

    List<Team> findByDivision(String dvision);
}
