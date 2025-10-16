package com.crediapi.infrastructure.adapter;

import com.crediapi.infrastructure.entity.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoanJpaRepository extends JpaRepository<LoanEntity, Long> {
    Optional<LoanEntity> findByApplicationId(Long applicationId);
}