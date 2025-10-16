package com.crediapi.domain.model;

import com.crediapi.domain.valueobject.Money;
import com.crediapi.domain.valueobject.Rate;
import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Value
@Builder
@With
public class Loan {
    Long id;
    Long applicationId;
    Money principal;
    Rate annualNominalRate;
    String currency;
    LoanStatus status;
    LocalDate disbursementDate;
    LocalDateTime createdAt;
    
    public Loan disburse(LocalDate disbursementDate) {
        if (status != LoanStatus.APPROVED) {
            throw new IllegalStateException("Only approved loans can be disbursed");
        }
        return withStatus(LoanStatus.DISBURSED)
               .withDisbursementDate(disbursementDate);
    }
}