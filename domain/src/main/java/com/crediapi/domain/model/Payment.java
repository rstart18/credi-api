package com.crediapi.domain.model;

import com.crediapi.domain.valueobject.Money;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class Payment {
    Long id;
    Long loanId;
    LocalDateTime paidAt;
    Money amount;
    String method;
}