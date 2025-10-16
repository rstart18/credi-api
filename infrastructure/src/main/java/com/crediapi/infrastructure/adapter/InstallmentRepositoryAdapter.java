package com.crediapi.infrastructure.adapter;

import com.crediapi.domain.model.Installment;
import com.crediapi.domain.model.InstallmentStatus;
import com.crediapi.domain.spi.InstallmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class InstallmentRepositoryAdapter implements InstallmentRepository {
    private final InstallmentJpaRepository jpaRepository;
    
    @Override
    public Installment save(Installment installment) {
        // TODO: Implement with mapper
        return installment;
    }
    
    @Override
    public List<Installment> saveAll(List<Installment> installments) {
        // TODO: Implement with mapper
        return installments;
    }
    
    @Override
    public List<Installment> findByLoanIdOrderByNumber(Long loanId) {
        // TODO: Implement with mapper
        return List.of();
    }
    
    @Override
    public Optional<Installment> findFirstByLoanIdAndStatusOrderByNumber(Long loanId, InstallmentStatus status) {
        // TODO: Implement with mapper
        return Optional.empty();
    }
}