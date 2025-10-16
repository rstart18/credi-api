package com.crediapi.infrastructure.config;

import com.crediapi.domain.spi.Clock;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class ClockAdapter implements Clock {
    
    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }
    
    @Override
    public LocalDate today() {
        return LocalDate.now();
    }
}