package com.crediapi.domain.model;

import com.crediapi.domain.valueobject.Money;
import com.crediapi.domain.valueobject.Rate;
import lombok.Builder;
import lombok.Value;
import lombok.With;

@Value
@Builder
@With
public class LoanProduct {
    Long id;
    String name;
    Rate annualNominalRate;
    AmortizationMethod amortizationMethod;
    Money minAmount;
    Money maxAmount;
    Integer minTerm;
    Integer maxTerm;
    
    public boolean isValidAmount(Money amount) {
        return amount.getAmount().compareTo(minAmount.getAmount()) >= 0 &&
               amount.getAmount().compareTo(maxAmount.getAmount()) <= 0;
    }
    
    public boolean isValidTerm(Integer term) {
        return term >= minTerm && term <= maxTerm;
    }
}