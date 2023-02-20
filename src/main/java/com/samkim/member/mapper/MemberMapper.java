package com.samkim.member.mapper;

import com.samkim.member.Member;
import com.samkim.member.dto.MemberPatchDto;
import com.samkim.member.dto.MemberPostDto;
import com.samkim.member.dto.MemberResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostToDto (MemberPostDto memberPostDto);
    Member memberPatchToDto (MemberPatchDto memberPatchDto);
    MemberResponseDto memberResponse (Member member);
}
