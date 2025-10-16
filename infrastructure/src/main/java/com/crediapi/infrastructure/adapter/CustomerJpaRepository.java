package com.crediapi.infrastructure.adapter;

import com.crediapi.infrastructure.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, Long> {
    boolean existsByDocumentId(String documentId);
}