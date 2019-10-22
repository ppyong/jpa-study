package com.skp.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private long teamId;

    @Column(name = "TEAM_NAME")
    private String teamName;

    @OneToMany(mappedBy = "team", orphanRemoval = true) // , fetch = FetchType.EAGER
    List<Member> members = new ArrayList<>();
}
