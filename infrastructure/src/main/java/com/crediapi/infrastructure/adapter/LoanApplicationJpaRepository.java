package com.crediapi.infrastructure.adapter;

import com.crediapi.infrastructure.entity.LoanApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanApplicationJpaRepository extends JpaRepository<LoanApplicationEntity, Long> {
}