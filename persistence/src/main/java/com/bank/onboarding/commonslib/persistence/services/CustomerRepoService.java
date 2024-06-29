package com.bank.onboarding.commonslib.persistence.services;

import com.bank.onboarding.commonslib.persistence.models.Customer;

import java.util.Collection;
import java.util.List;

public interface CustomerRepoService {
    Customer saveCustomerDB(Customer customer);
    Customer getCustomerByNumber(String customerNumber);
    void deleteCustomerByNumber(String customerNumber);

    List<Customer> getCustomersByNumber(String customerNumber);
}
