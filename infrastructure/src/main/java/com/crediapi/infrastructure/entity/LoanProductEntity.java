package com.crediapi.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "loan_products")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(name = "annual_nominal_rate", nullable = false, precision = 8, scale = 6)
    private BigDecimal annualNominalRate;
    
    @Column(name = "amortization_method", nullable = false)
    private String amortizationMethod;
    
    @Column(name = "min_amount", nullable = false, precision = 15, scale = 2)
    private BigDecimal minAmount;
    
    @Column(name = "max_amount", nullable = false, precision = 15, scale = 2)
    private BigDecimal maxAmount;
    
    @Column(name = "min_term", nullable = false)
    private Integer minTerm;
    
    @Column(name = "max_term", nullable = false)
    private Integer maxTerm;
}