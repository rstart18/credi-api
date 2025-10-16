package com.crediapi.domain.spi;

import com.crediapi.domain.model.LoanApplication;

import java.util.Optional;

public interface LoanApplicationRepository {
    LoanApplication save(LoanApplication application);
    Optional<LoanApplication> findById(Long id);
}