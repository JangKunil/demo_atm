package com.example.eunboard.controller;

import com.example.eunboard.domain.dto.MemberDTO;
import com.example.eunboard.domain.dto.request.MemberRequestDTO;
import com.example.eunboard.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@Slf4j
@RequiredArgsConstructor
@RestController
public class MemberAPI {

    private final MemberService memberService;


    @ResponseBody
    @PostMapping("/member/new")
    public String createMember(@RequestBody HashMap<String, Object> param) {

        MemberDTO dto =new MemberDTO();
        dto.setMemberName(param.get("memberName").toString());
        dto.setPhoneNumber(param.get("phoneNumber").toString());
        dto.setEmail(param.get("email").toString());
        dto.setPassword(param.get("password").toString());
        dto.setMoney((long)0);
        // 계좌 난수 생성 추가 필요
        dto.setAccountNumber("1234");

        return memberService.createMember(dto);
    }
}
