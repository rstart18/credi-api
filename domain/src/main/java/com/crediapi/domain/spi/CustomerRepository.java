package com.crediapi.domain.spi;

import com.crediapi.domain.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CustomerRepository {
    Customer save(Customer customer);
    Optional<Customer> findById(Long id);
    Page<Customer> findAll(Pageable pageable);
    boolean existsByDocumentId(String documentId);
}