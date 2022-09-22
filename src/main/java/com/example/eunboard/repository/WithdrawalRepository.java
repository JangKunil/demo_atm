package com.example.eunboard.repository;

import com.example.eunboard.domain.entity.Deposit;
import com.example.eunboard.domain.entity.Withdrawal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WithdrawalRepository extends JpaRepository<Withdrawal, Long> {

    Withdrawal findByEmail(String email);
}