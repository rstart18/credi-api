package com.crediapi.application.usecase;

import com.crediapi.domain.model.LoanApplication;
import com.crediapi.domain.model.LoanApplicationStatus;
import com.crediapi.domain.spi.LoanApplicationRepository;
import com.crediapi.domain.spi.CustomerRepository;
import com.crediapi.domain.spi.LoanProductRepository;
import com.crediapi.domain.spi.Clock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateApplicationUseCase {
    private final LoanApplicationRepository applicationRepository;
    private final CustomerRepository customerRepository;
    private final LoanProductRepository productRepository;
    private final Clock clock;
    
    public LoanApplication execute(LoanApplication application) {
        // Validate customer exists
        customerRepository.findById(application.getCustomerId())
            .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
        
        // Validate product exists
        productRepository.findById(application.getProductId())
            .orElseThrow(() -> new IllegalArgumentException("Product not found"));
        
        LoanApplication applicationToSave = application
            .withStatus(LoanApplicationStatus.SUBMITTED)
            .withCreatedAt(clock.now());
            
        return applicationRepository.save(applicationToSave);
    }
}