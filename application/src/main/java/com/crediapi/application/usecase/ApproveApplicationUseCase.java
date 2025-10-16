package com.crediapi.application.usecase;

import com.crediapi.application.service.LoanApplicationService;
import com.crediapi.application.validator.LoanApplicationValidator;
import com.crediapi.domain.model.*;
import com.crediapi.domain.spi.*;
import com.crediapi.domain.valueobject.Money;
import com.crediapi.application.service.LoanCreationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ApproveApplicationUseCase implements LoanApplicationService {
    private final LoanApplicationRepository applicationRepository;
    private final LoanProductRepository productRepository;
    private final CustomerRepository customerRepository;
    private final LoanApplicationValidator applicationValidator;
    private final LoanCreationService loanCreationService;
    
    @Override
    public LoanApplication createApplication(Long customerId, Long productId, Money amount, Integer termMonths) {
        Customer customer = customerRepository.findById(customerId)
            .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
        
        LoanProduct product = productRepository.findById(productId)
            .orElseThrow(() -> new IllegalArgumentException("Product not found"));
        
        applicationValidator.validateAmountAndTerm(amount, termMonths, product);
        
        LoanApplication application = LoanApplication.builder()
            .customerId(customerId)
            .productId(productId)
            .amount(amount)
            .termMonths(termMonths)
            .status(LoanApplicationStatus.DRAFT)
            .build();
        
        return applicationRepository.save(application);
    }
    
    @Override
    public Loan approveApplication(Long applicationId) {
        LoanApplication application = applicationRepository.findById(applicationId)
            .orElseThrow(() -> new IllegalArgumentException("Application not found"));
        
        LoanProduct product = productRepository.findById(application.getProductId())
            .orElseThrow(() -> new IllegalArgumentException("Product not found"));
        
        applicationValidator.validateApplicationForApproval(application);
        applicationValidator.validateAmountAndTerm(application.getAmount(), application.getTermMonths(), product);
        
        LoanApplication approvedApplication = application.approve();
        applicationRepository.save(approvedApplication);
        
        return loanCreationService.createLoanWithInstallments(approvedApplication, product);
    }
}