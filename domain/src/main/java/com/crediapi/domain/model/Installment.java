package com.crediapi.domain.model;

import com.crediapi.domain.valueobject.Money;
import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.time.LocalDate;

@Value
@Builder
@With
public class Installment {
    Long id;
    Long loanId;
    Integer number;
    LocalDate dueDate;
    Money principal;
    Money interest;
    Money fees;
    Money balanceAfter;
    InstallmentStatus status;
    
    public Installment markAsPaid() {
        return withStatus(InstallmentStatus.PAID);
    }
}