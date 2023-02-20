package com.samkim.member.controller;

import com.samkim.member.*;
import com.samkim.member.dto.MemberPatchDto;
import com.samkim.member.dto.MemberPostDto;
import com.samkim.member.mapper.MemberMapper;
import com.samkim.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/study1/member")
@Validated
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper mapper;

    public MemberController(MemberService memberService, MemberMapper mapper) {
        this.memberService = memberService;
        this.mapper = mapper;
    }
    @PostMapping
    public ResponseEntity postmember (@Valid @RequestBody MemberPostDto memberPostDto) {
        Member member = mapper.memberPostToDto(memberPostDto);
        Member response = memberService.createMember(member);
        return new ResponseEntity<>(mapper.memberResponse(response), HttpStatus.CREATED);
    }
    @PatchMapping("/{member-Id}")
    public ResponseEntity patchmember (@PathVariable("member-Id") @Positive long memberId, @Valid @RequestBody MemberPatchDto memberPatchDto) {
        memberPatchDto.setMemberId(memberId);
        Member member = mapper.memberPatchToDto(memberPatchDto);
        Member response = memberService.updateMember(member);
        return new ResponseEntity<>(mapper.memberResponse(response), HttpStatus.OK);
    }
    @GetMapping("/{member-Id}")
    public ResponseEntity findmember (@PathVariable("member-Id") @Positive long memberId) {
        Member response = memberService.getMember(memberId);
        return new ResponseEntity<>(mapper.memberResponse(response), HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity deletemember () {
        memberService.delteMember();
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
