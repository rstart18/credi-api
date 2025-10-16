package com.crediapi.domain.spi;

import com.crediapi.domain.model.LoanProduct;

import java.util.List;
import java.util.Optional;

public interface LoanProductRepository {
    LoanProduct save(LoanProduct product);
    Optional<LoanProduct> findById(Long id);
    List<LoanProduct> findAll();
}