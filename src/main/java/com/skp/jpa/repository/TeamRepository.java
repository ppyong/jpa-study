package com.skp.jpa.repository;

import com.skp.jpa.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
    public Team findByTeamName(String teamName);
}
