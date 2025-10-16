package com.crediapi.infrastructure.adapter;

import com.crediapi.domain.model.LoanApplication;
import com.crediapi.domain.spi.LoanApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LoanApplicationRepositoryAdapter implements LoanApplicationRepository {
    private final LoanApplicationJpaRepository jpaRepository;
    
    @Override
    public LoanApplication save(LoanApplication application) {
        // TODO: Implement with mapper
        return application;
    }
    
    @Override
    public Optional<LoanApplication> findById(Long id) {
        // TODO: Implement with mapper
        return Optional.empty();
    }
}