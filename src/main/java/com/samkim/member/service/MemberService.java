package com.samkim.member.service;

import com.samkim.member.Member;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    public Member createMember (Member member) {
        return member;
    }
    public Member updateMember (Member member) {
        return member;
    }
    public Member getMember (long memberId) {
        Member member = new Member (memberId, "김고객", "010-1111-2222", "naver@naver.com", 178);
        return member;
    }
    public void delteMember () {
    }
}
