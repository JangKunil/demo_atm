package com.example.eunboard.controller;

import com.example.eunboard.domain.dto.DepositDTO;
import com.example.eunboard.domain.dto.MemberDTO;
import com.example.eunboard.domain.dto.request.MemberRequestDTO;
import com.example.eunboard.service.DepositService;
import com.example.eunboard.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequiredArgsConstructor
@RestController
public class DepositAPI {

    private final DepositService depositService;


    @PostMapping("/deposit/new")
    public void createMember(@RequestBody DepositDTO requestDTO) {
        depositService.createDeposit(requestDTO);
    }
}
