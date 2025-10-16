package com.crediapi.domain.valueobject;

import lombok.Value;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Value
public class Rate {
    BigDecimal annualNominal;
    
    public Rate(BigDecimal annualNominal) {
        this.annualNominal = annualNominal.setScale(6, RoundingMode.HALF_UP);
    }
    
    public BigDecimal getMonthlyRate() {
        return annualNominal.divide(BigDecimal.valueOf(12), 6, RoundingMode.HALF_UP);
    }
}