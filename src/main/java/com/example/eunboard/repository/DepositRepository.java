package com.example.eunboard.repository;

import com.example.eunboard.domain.entity.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositRepository extends JpaRepository<Deposit, Long> {

    Deposit findByEmail(String email);

    Boolean existsByEmail(String email);
}