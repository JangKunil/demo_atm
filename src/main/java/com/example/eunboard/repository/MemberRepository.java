package com.example.eunboard.repository;

import com.example.eunboard.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByEmail(String email);

    Member findByAccountNumber(String accountNumber);

    Boolean existsByEmail(String email);

    Boolean existsByAccountNumber(String accountNumber);
}