package com.bank.onboarding.commonslib.persistence.services;

import com.bank.onboarding.commonslib.persistence.models.Customer;
import com.bank.onboarding.commonslib.persistence.models.CustomerRef;

import java.util.List;

public interface CustomerRefRepoService {
    CustomerRef findCustomerDB(String customerNumber);
}
