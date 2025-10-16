package com.crediapi.domain.spi;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Clock {
    LocalDateTime now();
    LocalDate today();
}