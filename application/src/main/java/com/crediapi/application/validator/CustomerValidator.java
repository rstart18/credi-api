package com.crediapi.application.validator;

import com.crediapi.domain.spi.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerValidator {
    private final CustomerRepository customerRepository;
    
    public void validateUniqueDocument(String documentId) {
        if (customerRepository.existsByDocumentId(documentId)) {
            throw new IllegalArgumentException("Customer with document ID already exists");
        }
    }
}