package com.IGallinari.LastGame.service;

import com.IGallinari.LastGame.entity.Team;
import com.IGallinari.LastGame.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamService {
    private TeamRepository teamRepository;

    public Team getTeamById(int inputId){
        return teamRepository.findById(inputId);
    }
}
