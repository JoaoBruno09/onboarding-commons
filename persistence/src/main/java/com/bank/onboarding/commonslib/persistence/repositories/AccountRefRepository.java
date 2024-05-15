package com.bank.onboarding.commonslib.persistence.repositories;

import com.bank.onboarding.commonslib.persistence.models.AccountRef;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRefRepository extends MongoRepository<AccountRef, String> {
    AccountRef findByAccountNumber(String accountNumber);
}
