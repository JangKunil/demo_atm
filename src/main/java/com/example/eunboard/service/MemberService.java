package com.example.eunboard.service;

import com.example.eunboard.domain.dto.MemberDTO;
import com.example.eunboard.domain.dto.request.MemberRequestDTO;
import com.example.eunboard.domain.entity.Member;
import com.example.eunboard.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public String createMember(MemberDTO requestDTO) {
        if (null == requestDTO || null == requestDTO.getEmail()) {
            throw new RuntimeException("Invalid arguments");
        }

        final String email = requestDTO.getEmail();
        if (memberRepository.existsByEmail(email)) {
            log.debug("MemberService.create Email already exists {}", email);
            return "이메일이 존재 합니다.";
        }

        final String accountNumber = requestDTO.getAccountNumber();
        if (memberRepository.existsByAccountNumber(accountNumber)) {
            log.debug("MemberService.create accountNumber already exists {}", email);
            return "계좌 번호가 존재 합니다.";
        }

        Member member = MemberDTO.toEntity(requestDTO);
        memberRepository.save(member);
        return "신규 가입 완료.";
    }

}
