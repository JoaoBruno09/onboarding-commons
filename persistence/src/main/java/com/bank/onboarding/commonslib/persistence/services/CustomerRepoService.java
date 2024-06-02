package com.bank.onboarding.commonslib.persistence.services;

import com.bank.onboarding.commonslib.persistence.models.Customer;

import java.util.List;

public interface CustomerRepoService {
    List<Customer> getAllCustomers();
    Customer saveCustomerDB(Customer customer);
    Customer getCustomerById(String customerId);
    Customer getCustomerByNumber(String customerNumber);
    void deleteCustomerById(String customerId);
}
