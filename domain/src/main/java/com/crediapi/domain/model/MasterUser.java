package com.crediapi.domain.model;

import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.time.LocalDateTime;
import java.util.Set;

@Value
@Builder
@With
public class MasterUser {
    Long id;
    String username;
    String email;
    String firstName;
    String lastName;
    Boolean active;
    LocalDateTime createdAt;
    Set<Role> roles;
}