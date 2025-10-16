package com.crediapi.domain.spi;

import com.crediapi.domain.model.Loan;

import java.util.Optional;

public interface LoanRepository {
    Loan save(Loan loan);
    Optional<Loan> findById(Long id);
    Optional<Loan> findByApplicationId(Long applicationId);
}