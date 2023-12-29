package com.IGallinari.LastGame.service;

import com.IGallinari.LastGame.entity.Team;
import com.IGallinari.LastGame.payload.response.ListTeams.*;
import com.IGallinari.LastGame.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;

    public Team getTeamById(int inputId){
        return teamRepository.findById(inputId);
    }

    public TeamsResponse buildTeams(){
        ViewConferenceEast conferenceEast = new ViewConferenceEast(
                buildViewDivision("Atlantic"),
                buildViewDivision("Central"),
                buildViewDivision("Southeast")
        );
        ViewConferenceWest conferenceWest = new ViewConferenceWest(
                buildViewDivision("Northwest"),
                buildViewDivision("Pacific"),
                buildViewDivision("Southwest")
        );
        return new TeamsResponse(conferenceWest, conferenceEast);
    }

    public TeamsNoConferenceResponse buildTeamsNoConferece(){
        TeamsNoConferenceResponse teamsNoConferenceResponse = new TeamsNoConferenceResponse(
                buildViewDivision("Atlantic"),
                buildViewDivision("Central"),
                buildViewDivision("Northwest"),
                buildViewDivision("Pacific"),
                buildViewDivision("Southeast"),
                buildViewDivision("Southwest")
        );
        return teamsNoConferenceResponse;
    }

    public ViewDivision buildViewDivision(String division){
        List<Team> teamsByDivision= teamRepository.findByDivision(division);
        List<ViewTeam> listViewTeams= new ArrayList<>();
        for (Team team: teamsByDivision){
            listViewTeams.add(
                    new ViewTeam(
                            team.getId(),
                            team.getNickname(),
                            team.getName(),
                            team.getLogo(),
                            null//DA IMPLEMENTARE QUANDO AVRO I PREFERITI
                    )
            );
        }
        return new ViewDivision(listViewTeams);
    }
}
