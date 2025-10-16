package com.crediapi.application.service;

import com.crediapi.domain.model.*;
import com.crediapi.domain.valueobject.Money;
import com.crediapi.domain.spi.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanCreationService {
    private final LoanRepository loanRepository;
    private final InstallmentRepository installmentRepository;
    private final Clock clock;
    
    public Loan createLoanWithInstallments(LoanApplication application, LoanProduct product) {
        // Create loan
        Loan loan = Loan.builder()
            .applicationId(application.getId())
            .principal(application.getAmount())
            .annualNominalRate(product.getAnnualNominalRate())
            .currency(application.getAmount().getCurrency())
            .status(LoanStatus.APPROVED)
            .createdAt(clock.now())
            .build();
        
        Loan savedLoan = loanRepository.save(loan);
        
        // Generate installments using French method
        List<Installment> installments = generateFrenchInstallments(
            savedLoan.getId(),
            application.getAmount(),
            product.getAnnualNominalRate().getMonthlyRate(),
            application.getTermMonths(),
            clock.today()
        );
        
        installmentRepository.saveAll(installments);
        
        return savedLoan;
    }
    
    private List<Installment> generateFrenchInstallments(Long loanId, Money principal, 
                                                        BigDecimal monthlyRate, Integer termMonths, 
                                                        LocalDate startDate) {
        List<Installment> installments = new ArrayList<>();
        
        // Calculate fixed monthly payment using French formula
        BigDecimal monthlyPayment = calculateMonthlyPayment(principal.getAmount(), monthlyRate, termMonths);
        BigDecimal remainingBalance = principal.getAmount();
        
        for (int i = 1; i <= termMonths; i++) {
            BigDecimal interestAmount = remainingBalance.multiply(monthlyRate).setScale(2, RoundingMode.HALF_UP);
            BigDecimal principalAmount = monthlyPayment.subtract(interestAmount).setScale(2, RoundingMode.HALF_UP);
            
            // Adjust last installment to avoid rounding issues
            if (i == termMonths) {
                principalAmount = remainingBalance;
            }
            
            remainingBalance = remainingBalance.subtract(principalAmount);
            
            Installment installment = Installment.builder()
                .loanId(loanId)
                .number(i)
                .dueDate(startDate.plusMonths(i))
                .principal(new Money(principalAmount, principal.getCurrency()))
                .interest(new Money(interestAmount, principal.getCurrency()))
                .fees(new Money(BigDecimal.ZERO, principal.getCurrency()))
                .balanceAfter(new Money(remainingBalance, principal.getCurrency()))
                .status(InstallmentStatus.PENDING)
                .build();
            
            installments.add(installment);
        }
        
        return installments;
    }
    
    private BigDecimal calculateMonthlyPayment(BigDecimal principal, BigDecimal monthlyRate, Integer termMonths) {
        if (monthlyRate.compareTo(BigDecimal.ZERO) == 0) {
            return principal.divide(BigDecimal.valueOf(termMonths), 2, RoundingMode.HALF_UP);
        }
        
        BigDecimal onePlusRate = BigDecimal.ONE.add(monthlyRate);
        BigDecimal factor = onePlusRate.pow(termMonths);
        
        return principal
            .multiply(monthlyRate)
            .multiply(factor)
            .divide(factor.subtract(BigDecimal.ONE), 2, RoundingMode.HALF_UP);
    }
}