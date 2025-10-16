package com.crediapi.domain.spi;

import com.crediapi.domain.model.Installment;

import java.util.List;
import java.util.Optional;

public interface InstallmentRepository {
    Installment save(Installment installment);
    List<Installment> saveAll(List<Installment> installments);
    List<Installment> findByLoanIdOrderByNumber(Long loanId);
    Optional<Installment> findFirstByLoanIdAndStatusOrderByNumber(Long loanId, com.crediapi.domain.model.InstallmentStatus status);
}