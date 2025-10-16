package com.crediapi.application.usecase;

import com.crediapi.application.service.CustomerService;
import com.crediapi.application.validator.CustomerValidator;
import com.crediapi.domain.model.Customer;
import com.crediapi.domain.valueobject.DocumentId;
import com.crediapi.domain.valueobject.Email;
import com.crediapi.domain.valueobject.Phone;
import com.crediapi.domain.spi.CustomerRepository;
import com.crediapi.domain.spi.Clock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateCustomerUseCase implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerValidator customerValidator;
    private final Clock clock;
    
    @Override
    public Customer createCustomer(String fullName, String documentId, String email, String phone) {
        customerValidator.validateUniqueDocument(documentId);
        
        Customer customer = Customer.builder()
            .fullName(fullName)
            .documentId(new DocumentId(documentId))
            .email(new Email(email))
            .phone(new Phone(phone))
            .createdAt(clock.now())
            .build();
        
        return customerRepository.save(customer);
    }
    
    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
    }
}