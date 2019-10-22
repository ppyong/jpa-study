package com.skp.jpa.service;

import com.skp.jpa.entity.Team;
import com.skp.jpa.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeamService {
    private final TeamRepository teamRepository;

    public Team getTeam(String teamName){
        return teamRepository.findByTeamName(teamName);
    }

    public void addTeam(String teamName){
        Team team = new Team();
        team.setTeamName(teamName);
        teamRepository.save(team);
    }
}
