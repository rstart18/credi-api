package com.crediapi.infrastructure.adapter;

import com.crediapi.domain.model.Customer;
import com.crediapi.domain.spi.CustomerRepository;
import com.crediapi.infrastructure.mapper.entity.CustomerEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryAdapter implements CustomerRepository {
    private final CustomerJpaRepository jpaRepository;
    private final CustomerEntityMapper mapper;
    
    @Override
    public Customer save(Customer customer) {
        var entity = mapper.toEntity(customer);
        var savedEntity = jpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }
    
    @Override
    public Optional<Customer> findById(Long id) {
        return jpaRepository.findById(id)
            .map(mapper::toDomain);
    }
    
    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return jpaRepository.findAll(pageable)
            .map(mapper::toDomain);
    }
    
    @Override
    public boolean existsByDocumentId(String documentId) {
        return jpaRepository.existsByDocumentId(documentId);
    }
}