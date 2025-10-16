package com.crediapi.application.usecase;

import com.crediapi.domain.model.Loan;
import com.crediapi.domain.spi.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional
public class DisburseLoanUseCase {
    private final LoanRepository loanRepository;
    
    public Loan execute(Long loanId, LocalDate disbursementDate) {
        Loan loan = loanRepository.findById(loanId)
            .orElseThrow(() -> new IllegalArgumentException("Loan not found"));
        
        Loan disbursedLoan = loan.disburse(disbursementDate);
        return loanRepository.save(disbursedLoan);
    }
}