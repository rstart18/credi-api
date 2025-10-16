package com.crediapi.infrastructure.mapper.dto;

import com.crediapi.domain.model.Customer;
import com.crediapi.api.dto.CustomerResponse;
import org.mapstruct.Mapper;

import java.time.ZoneOffset;

@Mapper(componentModel = "spring")
public interface CustomerDtoMapper {
    
    default CustomerResponse toResponse(Customer customer) {
        if (customer == null) {
            return null;
        }
        
        CustomerResponse response = new CustomerResponse();
        response.setId(customer.getId());
        response.setFullName(customer.getFullName());
        response.setDocumentId(customer.getDocumentId().getValue());
        response.setEmail(customer.getEmail().getValue());
        response.setPhone(customer.getPhone().getValue());
        response.setCreatedAt(customer.getCreatedAt() != null ? 
            customer.getCreatedAt().atOffset(ZoneOffset.UTC) : null);
        
        return response;
    }
}