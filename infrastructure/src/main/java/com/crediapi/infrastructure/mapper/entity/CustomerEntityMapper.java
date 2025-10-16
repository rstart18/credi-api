package com.crediapi.infrastructure.mapper.entity;

import com.crediapi.domain.model.Customer;
import com.crediapi.domain.valueobject.DocumentId;
import com.crediapi.domain.valueobject.Email;
import com.crediapi.domain.valueobject.Phone;
import com.crediapi.infrastructure.entity.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {
    
    default CustomerEntity toEntity(Customer customer) {
        if (customer == null) {
            return null;
        }
        
        return CustomerEntity.builder()
            .id(customer.getId())
            .fullName(customer.getFullName())
            .documentId(customer.getDocumentId().getValue())
            .email(customer.getEmail().getValue())
            .phone(customer.getPhone().getValue())
            .createdAt(customer.getCreatedAt())
            .build();
    }
    
    default Customer toDomain(CustomerEntity entity) {
        if (entity == null) {
            return null;
        }
        
        return Customer.builder()
            .id(entity.getId())
            .fullName(entity.getFullName())
            .documentId(new DocumentId(entity.getDocumentId()))
            .email(new Email(entity.getEmail()))
            .phone(new Phone(entity.getPhone()))
            .createdAt(entity.getCreatedAt())
            .build();
    }
}