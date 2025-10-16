package com.crediapi.infrastructure.adapter;

import com.crediapi.infrastructure.entity.LoanProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanProductJpaRepository extends JpaRepository<LoanProductEntity, Long> {
}