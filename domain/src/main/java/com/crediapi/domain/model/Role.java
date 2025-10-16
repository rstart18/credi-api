package com.crediapi.domain.model;

import lombok.Builder;
import lombok.Value;

import java.util.Set;

@Value
@Builder
public class Role {
    Long id;
    String name;
    String description;
    Set<Permission> permissions;
}