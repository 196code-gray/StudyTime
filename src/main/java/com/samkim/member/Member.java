package com.samkim.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Member {
    private long memberId;
    private String name;
    private String phone;
    private String email;
    private int height;
}
