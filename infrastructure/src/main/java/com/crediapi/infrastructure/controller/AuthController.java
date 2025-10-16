package com.crediapi.infrastructure.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    
    @PostMapping("/token")
    public ResponseEntity<Map<String, Object>> getToken(@RequestBody Map<String, String> credentials) {
        // Mock token generation for testing
        String username = credentials.get("username");
        String password = credentials.get("password");
        
        // Simple validation (for testing only)
        if ("admin".equals(username) && "admin123".equals(password)) {
            String mockToken = generateMockJWT(username);
            
            return ResponseEntity.ok(Map.of(
                "access_token", mockToken,
                "token_type", "Bearer",
                "expires_in", 3600,
                "username", username
            ));
        }
        
        return ResponseEntity.status(401).body(Map.of("error", "Invalid credentials"));
    }
    
    private String generateMockJWT(String username) {
        // Mock JWT structure (header.payload.signature)
        String header = Base64.getEncoder().encodeToString(
            "{\"alg\":\"HS256\",\"typ\":\"JWT\"}".getBytes()
        );
        
        long exp = Instant.now().plus(1, ChronoUnit.HOURS).getEpochSecond();
        String payload = Base64.getEncoder().encodeToString(
            String.format("{\"sub\":\"%s\",\"exp\":%d,\"iat\":%d}", 
                username, exp, Instant.now().getEpochSecond()).getBytes()
        );
        
        String signature = Base64.getEncoder().encodeToString("mock-signature".getBytes());
        
        return header + "." + payload + "." + signature;
    }
}