package com.crediapi.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "loans")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "application_id", nullable = false)
    private Long applicationId;
    
    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal principal;
    
    @Column(name = "annual_nominal_rate", nullable = false, precision = 8, scale = 6)
    private BigDecimal annualNominalRate;
    
    @Column(nullable = false)
    private String currency;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LoanStatusEntity status;
    
    @Column(name = "disbursement_date")
    private LocalDate disbursementDate;
    
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}