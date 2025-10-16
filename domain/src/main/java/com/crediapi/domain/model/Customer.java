package com.crediapi.domain.model;

import com.crediapi.domain.valueobject.DocumentId;
import com.crediapi.domain.valueobject.Email;
import com.crediapi.domain.valueobject.Phone;
import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.time.LocalDateTime;

@Value
@Builder
@With
public class Customer {
    Long id;
    String fullName;
    DocumentId documentId;
    Email email;
    Phone phone;
    LocalDateTime createdAt;
}