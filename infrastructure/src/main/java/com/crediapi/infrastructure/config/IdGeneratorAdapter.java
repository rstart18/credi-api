package com.crediapi.infrastructure.config;

import com.crediapi.domain.spi.IdGenerator;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class IdGeneratorAdapter implements IdGenerator {
    
    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}