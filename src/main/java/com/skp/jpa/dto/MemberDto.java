package com.skp.jpa.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberDto {
    private long memberId;
    private String memberName;
}
