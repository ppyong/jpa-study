package com.skp.jpa.service;

import com.skp.jpa.dto.MemberDto;
import com.skp.jpa.entity.Member;
import com.skp.jpa.entity.Team;
import com.skp.jpa.repository.MemberRepository;
import com.skp.jpa.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    //private final TeamRepository teamRepository;
    private final ModelMapper modelMapper;

    public void addMember(String memberName, Team team){
        Member member = new Member();
        member.setMemberName(memberName);
        setTeam(member, team);
        memberRepository.save(member);
    }

    public void deleteMember(long memberId){
        memberRepository.deleteById(memberId);
    }

    public void deleteAllMember(){
        memberRepository.deleteAll();
    }

    public List<MemberDto> getAllMember(){
        return memberRepository.findAll()
                .stream()
                .map(e->modelMapper.map(e, MemberDto.class))
                .collect(Collectors.toList());
    }

    public void setTeam(Member member, Team team){
        //Team team = teamRepository.findByTeamName(teamName);
        member.setTeam(team);
        member.getTeam().getMembers().add(member);
    }
}
