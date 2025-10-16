package com.crediapi.application.usecase;

import com.crediapi.domain.model.*;
import com.crediapi.domain.spi.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RegisterPaymentUseCase {
    private final PaymentRepository paymentRepository;
    private final InstallmentRepository installmentRepository;
    private final LoanRepository loanRepository;
    
    public Payment execute(Payment payment) {
        // Validate loan exists
        loanRepository.findById(payment.getLoanId())
            .orElseThrow(() -> new IllegalArgumentException("Loan not found"));
        
        // Find next pending installment
        Installment pendingInstallment = installmentRepository
            .findFirstByLoanIdAndStatusOrderByNumber(payment.getLoanId(), InstallmentStatus.PENDING)
            .orElseThrow(() -> new IllegalArgumentException("No pending installments found"));
        
        // Mark installment as paid (simplified logic)
        Installment paidInstallment = pendingInstallment.markAsPaid();
        installmentRepository.save(paidInstallment);
        
        return paymentRepository.save(payment);
    }
}