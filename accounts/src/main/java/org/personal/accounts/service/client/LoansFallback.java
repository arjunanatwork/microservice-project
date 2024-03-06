package org.personal.accounts.service.client;

import org.personal.accounts.dto.LoansDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class LoansFallback implements LoansFeignClient {
    @Override
    public ResponseEntity<LoansDTO> fetchLoanDetails(String correlationId, String mobileNumber) {
        return null;
    }
}
