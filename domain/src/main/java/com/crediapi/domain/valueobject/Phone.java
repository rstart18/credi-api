package com.crediapi.domain.valueobject;

import lombok.Value;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Value
public class Phone {
    @NotBlank
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone must be 10-15 digits")
    String value;
}