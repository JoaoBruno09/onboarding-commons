package com.bank.onboarding.persistence.repositories;

import com.bank.onboarding.persistence.models.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {
}
