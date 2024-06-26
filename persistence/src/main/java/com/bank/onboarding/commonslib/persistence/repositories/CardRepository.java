package com.bank.onboarding.commonslib.persistence.repositories;

import com.bank.onboarding.commonslib.persistence.models.Card;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CardRepository extends MongoRepository<Card, String> {
    Card findByNumber(String cardNumber);
    Card findByCustomerNumberAndAccountId(String customerNumber, String accountId);
    List<Card> findAllByAccountId(String accountId);
}
