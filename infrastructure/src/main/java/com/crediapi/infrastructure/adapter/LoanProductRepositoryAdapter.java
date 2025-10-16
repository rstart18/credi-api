package com.crediapi.infrastructure.adapter;

import com.crediapi.domain.model.LoanProduct;
import com.crediapi.domain.spi.LoanProductRepository;
import com.crediapi.infrastructure.mapper.LoanProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LoanProductRepositoryAdapter implements LoanProductRepository {
    private final LoanProductJpaRepository jpaRepository;
    private final LoanProductMapper mapper;
    
    @Override
    public LoanProduct save(LoanProduct product) {
        var entity = mapper.toEntity(product);
        var savedEntity = jpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }
    
    @Override
    public Optional<LoanProduct> findById(Long id) {
        return jpaRepository.findById(id)
            .map(mapper::toDomain);
    }
    
    @Override
    public List<LoanProduct> findAll() {
        return jpaRepository.findAll().stream()
            .map(mapper::toDomain)
            .toList();
    }
}