package org.personal.accounts.service;

import org.personal.accounts.dto.CustomerDetailsDTO;

public interface ICustomerService {

    CustomerDetailsDTO fetchCustomerDetails(String mobileNumber, String correlationId);
}
