package com.crediapi.infrastructure.adapter;

import com.crediapi.domain.model.Loan;
import com.crediapi.domain.spi.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LoanRepositoryAdapter implements LoanRepository {
    private final LoanJpaRepository jpaRepository;
    
    @Override
    public Loan save(Loan loan) {
        // TODO: Implement with mapper
        return loan;
    }
    
    @Override
    public Optional<Loan> findById(Long id) {
        // TODO: Implement with mapper
        return Optional.empty();
    }
    
    @Override
    public Optional<Loan> findByApplicationId(Long applicationId) {
        // TODO: Implement with mapper
        return Optional.empty();
    }
}