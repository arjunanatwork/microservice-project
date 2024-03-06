package org.personal.accounts.service.impl;

import lombok.RequiredArgsConstructor;
import org.personal.accounts.dto.*;
import org.personal.accounts.entity.Accounts;
import org.personal.accounts.entity.Customer;
import org.personal.accounts.exception.ResourceNotFoundException;
import org.personal.accounts.mapper.AccountsMapper;
import org.personal.accounts.mapper.CustomerMapper;
import org.personal.accounts.repository.AccountsRepository;
import org.personal.accounts.repository.CustomerRepository;
import org.personal.accounts.service.ICustomerService;
import org.personal.accounts.service.client.CardsFeignClient;
import org.personal.accounts.service.client.LoansFeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {
    
    private final AccountsRepository accountsRepository;
    private final CustomerRepository customerRepository;
    private final CardsFeignClient cardsFeignClient;
    private final LoansFeignClient loansFeignClient;

    @Override
    public CustomerDetailsDTO fetchCustomerDetails(String mobileNumber, String correlationId) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(() -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString()));
        CustomerDetailsDTO customerDetailsDTO = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDTO());
        customerDetailsDTO.setAccountsDTO(AccountsMapper.mapToAccountsDto(accounts, new AccountsDTO()));

        ResponseEntity<LoansDTO> loansDTOResponseEntity = loansFeignClient.fetchLoanDetails(correlationId, mobileNumber);
        if(loansDTOResponseEntity!=null)
            customerDetailsDTO.setLoansDTO(loansDTOResponseEntity.getBody());

        ResponseEntity<CardsDTO> cardsDTOResponseEntity = cardsFeignClient.fetchCardDetails(correlationId, mobileNumber);
        if(cardsDTOResponseEntity!=null)
            customerDetailsDTO.setCardsDTO(cardsDTOResponseEntity.getBody());

        return customerDetailsDTO;
    }
}
