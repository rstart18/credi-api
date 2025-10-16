package com.crediapi.infrastructure.mapper;

import com.crediapi.domain.model.AmortizationMethod;
import com.crediapi.domain.model.LoanProduct;
import com.crediapi.domain.valueobject.Money;
import com.crediapi.domain.valueobject.Rate;
import com.crediapi.infrastructure.entity.LoanProductEntity;
import org.springframework.stereotype.Component;

@Component
public class LoanProductMapper {
    
    public LoanProduct toDomain(LoanProductEntity entity) {
        return LoanProduct.builder()
            .id(entity.getId())
            .name(entity.getName())
            .annualNominalRate(new Rate(entity.getAnnualNominalRate()))
            .amortizationMethod(AmortizationMethod.valueOf(entity.getAmortizationMethod()))
            .minAmount(new Money(entity.getMinAmount(), "COP"))
            .maxAmount(new Money(entity.getMaxAmount(), "COP"))
            .minTerm(entity.getMinTerm())
            .maxTerm(entity.getMaxTerm())
            .build();
    }
    
    public LoanProductEntity toEntity(LoanProduct domain) {
        return LoanProductEntity.builder()
            .id(domain.getId())
            .name(domain.getName())
            .annualNominalRate(domain.getAnnualNominalRate().getAnnualNominal())
            .amortizationMethod(domain.getAmortizationMethod().name())
            .minAmount(domain.getMinAmount().getAmount())
            .maxAmount(domain.getMaxAmount().getAmount())
            .minTerm(domain.getMinTerm())
            .maxTerm(domain.getMaxTerm())
            .build();
    }
}