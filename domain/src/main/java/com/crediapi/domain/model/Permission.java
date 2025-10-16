package com.crediapi.domain.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Permission {
    Long id;
    String name;
    String module;
    String description;
}