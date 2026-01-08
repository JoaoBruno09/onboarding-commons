package com.bank.onboarding.commonslib.persistence.repositories;

import com.bank.onboarding.commonslib.persistence.models.CustomerRef;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRefRepository extends MongoRepository<CustomerRef, String> {
    CustomerRef findByCustomerNumber(String accountNumber);
    void deleteByCustomerNumber(String customerNumber);
    List<CustomerRef> findAllByAccountsAccountNumber(String accountNumber);
}
