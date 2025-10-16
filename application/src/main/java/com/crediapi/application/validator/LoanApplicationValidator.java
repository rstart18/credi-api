package com.crediapi.application.validator;

import com.crediapi.domain.model.LoanApplication;
import com.crediapi.domain.model.LoanApplicationStatus;
import com.crediapi.domain.model.LoanProduct;
import com.crediapi.domain.valueobject.Money;
import org.springframework.stereotype.Component;

@Component
public class LoanApplicationValidator {
    
    public void validateApplicationForApproval(LoanApplication application) {
        if (application.getStatus() != LoanApplicationStatus.SUBMITTED) {
            throw new IllegalArgumentException("Application cannot be approved in current status");
        }
    }
    
    public void validateAmountAndTerm(Money amount, Integer termMonths, LoanProduct product) {
        if (!product.isValidAmount(amount)) {
            throw new IllegalArgumentException("Amount not within product limits");
        }
        
        if (!product.isValidTerm(termMonths)) {
            throw new IllegalArgumentException("Term not within product limits");
        }
    }
}