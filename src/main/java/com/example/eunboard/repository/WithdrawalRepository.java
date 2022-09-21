package com.example.eunboard.repository;

import com.example.eunboard.domain.entity.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WithdrawalRepository extends JpaRepository<Deposit, Long> {
}