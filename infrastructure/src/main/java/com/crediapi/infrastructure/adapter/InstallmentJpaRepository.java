package com.crediapi.infrastructure.adapter;

import com.crediapi.infrastructure.entity.InstallmentEntity;
import com.crediapi.infrastructure.entity.InstallmentStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InstallmentJpaRepository extends JpaRepository<InstallmentEntity, Long> {
    List<InstallmentEntity> findByLoanIdOrderByNumber(Long loanId);
    Optional<InstallmentEntity> findFirstByLoanIdAndStatusOrderByNumber(Long loanId, InstallmentStatusEntity status);
}