package com.crediapi.domain.valueobject;

import lombok.Value;
import jakarta.validation.constraints.NotBlank;

@Value
public class Email {
    @NotBlank
    @jakarta.validation.constraints.Email
    String value;
}