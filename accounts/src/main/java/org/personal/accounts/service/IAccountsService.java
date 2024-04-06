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


    /**
     * Updates the customer account with the provided customer DTO.
     *
     * @param customerDTO the customer DTO containing the updated account details
     * @return true if the account is successfully updated, false otherwise
     */
    boolean updateAccount(CustomerDTO customerDTO);

    /**
     * Deletes the customer account associated with the given mobile number.
     *
     * @param mobileNumber the mobile number of the customer account to delete
     * @return true if the account is successfully deleted, false otherwise
     */
    boolean deleteAccount(String mobileNumber);

    /**
     * Updates the communication status of a customer account identified by the given account number.
     *
     * @param accountNumber the account number of the customer account to update
     * @return true if the communication status is successfully updated, false otherwise
     */
    boolean updateCommunicationStatus(Long accountNumber);
}
