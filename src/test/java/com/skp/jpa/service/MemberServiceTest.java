package com.skp.jpa.service;

import com.skp.jpa.dto.MemberDto;
import com.skp.jpa.entity.Team;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MemberServiceTest {
    @Autowired
    private MemberService memberService;

    @Autowired
    private TeamService teamService;

    public MemberServiceTest(){
    }

    @Test
    public void 맴버등록테스트(){
        // 팀 생성
        String newTeamName = "테스트팀";
        teamService.addTeam(newTeamName);

        Team team = teamService.getTeam(newTeamName);

        // 팀에 맴버 추가
        memberService.addMember("안지표1", team);
        memberService.addMember("안지표2", team);
        memberService.addMember("안지표3", team);
    }

    @Test
    public void 맴버리스트조회테스트(){
        List<MemberDto> members = memberService.getAllMember();
        members.forEach(i->{
            log.info(i.toString());
        });
    }
}
