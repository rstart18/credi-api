package com.crediapi.infrastructure.adapter;

import com.crediapi.domain.model.Payment;
import com.crediapi.domain.spi.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PaymentRepositoryAdapter implements PaymentRepository {
    private final PaymentJpaRepository jpaRepository;
    
    @Override
    public Payment save(Payment payment) {
        // TODO: Implement with mapper
        return payment;
    }
    
    @Override
    public List<Payment> findByLoanId(Long loanId) {
        // TODO: Implement with mapper
        return List.of();
    }
}