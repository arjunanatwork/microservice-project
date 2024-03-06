package org.personal.accounts.service.client;

import org.personal.accounts.dto.CardsDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CardsFallback implements CardsFeignClient {

    @Override
    public ResponseEntity<CardsDTO> fetchCardDetails(String correlationId, String mobileNumber) {
        return null;
    }
}
