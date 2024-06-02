package com.bank.onboarding.commonslib.persistence.services;

import com.bank.onboarding.commonslib.persistence.models.CustomerRef;

public interface CustomerRefRepoService {
    CustomerRef findCustomerRefByCustomerNumber(String customerNumber);
    void saveCustomerRefDB(CustomerRef customerRef);
    void deleteCustomerById(String customerId);
}
