package com.bank.onboarding.commonslib.persistence.repositories;

import com.bank.onboarding.commonslib.persistence.models.CustomerRef;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRefRepository extends MongoRepository<CustomerRef, String> {
    CustomerRef findByCustomerNumber(String accountNumber);
}
