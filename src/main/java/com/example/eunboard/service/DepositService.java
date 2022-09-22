package com.example.eunboard.service;

import com.example.eunboard.domain.dto.DepositDTO;
import com.example.eunboard.domain.dto.request.MemberRequestDTO;
import com.example.eunboard.domain.entity.Deposit;
import com.example.eunboard.domain.entity.Member;
import com.example.eunboard.repository.DepositRepository;
import com.example.eunboard.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DepositService {

    @Autowired
    private DepositRepository depositRepository;
    @Autowired
    private MemberRepository membertRepository;

    public Deposit create(final Deposit depositEntity) {
        if (null == depositEntity || null == depositEntity.getEmail()) {
            throw new RuntimeException("Invalid arguments");
        }
        final String email = depositEntity.getEmail();
        if (depositRepository.existsByEmail(email)) {
            log.debug("MemberService.create Email already exists {}", email);
            return depositRepository.findByEmail(email);
        }
        return depositRepository.save(depositEntity);
    }

    public void createDeposit(DepositDTO requestDTO) {
        // TODO : 일단 방어 설계 빼고, 기능 동작만
        // if (exists != null) {
        Deposit entity = DepositDTO.toEntity(requestDTO);
        depositRepository.save(entity);

        Member member = membertRepository.findByAccountNumber(requestDTO.getAccountNumber());
        long moneySum = member.getMoney() +  requestDTO.getMoney();
        member.setMoney( moneySum );

        membertRepository.save(member);
    }
}
