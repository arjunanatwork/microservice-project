package org.personal.accounts.functions;

import lombok.extern.slf4j.Slf4j;
import org.personal.accounts.service.IAccountsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@Slf4j
public class AccountsFunctions {

    @Bean
    public Consumer<Long> updateCommunication(IAccountsService iAccountsService) {
        return accountNumber -> {
            log.info("Updating communication for account number: {}", accountNumber.toString());
            iAccountsService.updateCommunicationStatus(accountNumber);
        };
    }
}
