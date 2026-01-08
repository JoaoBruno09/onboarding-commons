package com.bank.onboarding.commonslib.persistence.repositories;

import com.bank.onboarding.commonslib.persistence.models.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AccountRepository extends MongoRepository<Account, String> {
    Account findByNumber(String accountNumber);
    void deleteByNumber(String accountNumber);
    List<Account> findAllByIban(String iban);
}
