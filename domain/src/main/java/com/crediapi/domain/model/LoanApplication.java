package com.crediapi.domain.model;

import com.crediapi.domain.valueobject.Money;
import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.time.LocalDateTime;

@Value
@Builder
@With
public class LoanApplication {
    Long id;
    Long customerId;
    Long productId;
    Money amount;
    Integer termMonths;
    LoanApplicationStatus status;
    LocalDateTime createdAt;
    
    public LoanApplication approve() {
        if (status != LoanApplicationStatus.SUBMITTED) {
            throw new IllegalStateException("Only submitted applications can be approved");
        }
        return withStatus(LoanApplicationStatus.APPROVED);
    }
    
    public LoanApplication reject() {
        if (status != LoanApplicationStatus.SUBMITTED) {
            throw new IllegalStateException("Only submitted applications can be rejected");
        }
        return withStatus(LoanApplicationStatus.REJECTED);
    }
}