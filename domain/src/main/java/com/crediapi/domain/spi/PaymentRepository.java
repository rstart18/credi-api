package com.crediapi.domain.spi;

import com.crediapi.domain.model.Payment;

import java.util.List;

public interface PaymentRepository {
    Payment save(Payment payment);
    List<Payment> findByLoanId(Long loanId);
}