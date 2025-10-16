package com.crediapi.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "installments")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstallmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "loan_id", nullable = false)
    private Long loanId;
    
    @Column(nullable = false)
    private Integer number;
    
    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;
    
    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal principal;
    
    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal interest;
    
    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal fees;
    
    @Column(name = "balance_after", nullable = false, precision = 15, scale = 2)
    private BigDecimal balanceAfter;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private InstallmentStatusEntity status;
}