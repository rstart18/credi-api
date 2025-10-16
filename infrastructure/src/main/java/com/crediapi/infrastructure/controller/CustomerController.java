package com.crediapi.infrastructure.controller;

import com.crediapi.application.service.CustomerService;
import com.crediapi.domain.model.Customer;
import com.crediapi.api.dto.CustomerRequest;
import com.crediapi.api.dto.CustomerResponse;
import com.crediapi.infrastructure.mapper.dto.CustomerDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
    
    private final CustomerService customerService;
    private final CustomerDtoMapper customerDtoMapper;
    
    @PostMapping
    public ResponseEntity<CustomerResponse> createCustomer(@Valid @RequestBody CustomerRequest request) {
        Customer customer = customerService.createCustomer(
            request.getFullName(),
            request.getDocumentId(),
            request.getEmail(),
            request.getPhone()
        );
        
        CustomerResponse response = customerDtoMapper.toResponse(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        CustomerResponse response = customerDtoMapper.toResponse(customer);
        return ResponseEntity.ok(response);
    }
}