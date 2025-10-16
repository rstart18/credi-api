package com.crediapi.domain.valueobject;

import lombok.Value;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Value
public class DocumentId {
    @NotBlank
    @Pattern(regexp = "^[0-9]{8,12}$", message = "Document ID must be 8-12 digits")
    String value;
}