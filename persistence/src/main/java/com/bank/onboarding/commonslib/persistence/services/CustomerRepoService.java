package com.bank.onboarding.commonslib.persistence.services;

import com.bank.onboarding.commonslib.persistence.models.Customer;

public interface CustomerRepoService {
    Customer saveCustomerDB(Customer customer);
    Customer getCustomerByNumber(String customerNumber);
    void deleteCustomerByNumber(String customerNumber);
}
