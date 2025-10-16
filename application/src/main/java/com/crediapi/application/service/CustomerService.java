package com.crediapi.application.service;

import com.crediapi.domain.model.Customer;

public interface CustomerService {
    Customer createCustomer(String fullName, String documentId, String email, String phone);
    Customer getCustomerById(Long id);
}