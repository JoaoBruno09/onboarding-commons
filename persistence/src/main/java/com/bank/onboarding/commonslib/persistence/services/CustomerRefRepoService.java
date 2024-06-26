package com.bank.onboarding.commonslib.persistence.services;

import com.bank.onboarding.commonslib.persistence.models.CustomerRef;

import java.util.List;

public interface CustomerRefRepoService {
    CustomerRef findCustomerRefByCustomerNumber(String customerNumber);
    CustomerRef findCustomerRefByCustomerId(String customerId);
    void saveCustomerRefDB(CustomerRef customerRef);
    void deleteCustomerByNumber(String customerNumber);
    List<CustomerRef> getCustomersByAccountsAccountNumber(String accountNumber);
}
