package com.bank.onboarding.commonslib.persistence.repositories;

import com.bank.onboarding.commonslib.persistence.models.Card;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CardRepository extends MongoRepository<Card, String> {
    Card findByNumber(String cardNumber);
}
