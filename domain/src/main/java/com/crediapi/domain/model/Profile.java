package com.crediapi.domain.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Profile {
    Long id;
    String name;
    String description;
}