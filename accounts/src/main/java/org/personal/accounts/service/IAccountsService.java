package org.personal.accounts.service;

import org.personal.accounts.dto.CustomerDTO;

/**
 * This interface represents a service for creating customer accounts.
 */
public interface IAccountsService {


    /**
     * Creates a customer account.
     *
     * @param customerDTO the customer DTO containing the name, email, and mobile number
     */
    void createAccount(CustomerDTO customerDTO);


    /**
     * Fetches the customer account associated with the given mobile number.
     *
     * @param mobileNumber the mobile number of the customer account to fetch
     * @return the customer DTO of the fetched account
     */
    CustomerDTO fetchAccount(String mobileNumber);
}
