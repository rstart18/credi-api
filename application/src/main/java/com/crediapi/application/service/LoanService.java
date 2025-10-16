package com.crediapi.application.service;

import com.crediapi.domain.model.Installment;
import com.crediapi.domain.model.Loan;

import java.util.List;

public interface LoanService {
    Loan getLoanById(Long id);
    Loan disburseLoan(Long loanId);
    List<Installment> getLoanInstallments(Long loanId);
}