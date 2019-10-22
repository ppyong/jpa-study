package com.skp.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue
    private long memberId;

    @Column(name = "MEMBER_NAME")
    private String memberName;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;
}
