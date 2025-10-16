package com.crediapi.application.service;

import com.crediapi.domain.model.Loan;
import com.crediapi.domain.model.LoanApplication;
import com.crediapi.domain.valueobject.Money;

public interface LoanApplicationService {
    LoanApplication createApplication(Long customerId, Long productId, Money amount, Integer termMonths);
    Loan approveApplication(Long applicationId);
}