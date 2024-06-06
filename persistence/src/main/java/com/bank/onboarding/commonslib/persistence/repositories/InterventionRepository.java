package com.bank.onboarding.commonslib.persistence.repositories;

import com.bank.onboarding.commonslib.persistence.models.Intervention;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface InterventionRepository extends MongoRepository<Intervention, String> {
    List<Intervention> findAllByCustomerId (String customerId);
    Intervention findByAccountId(String accountId);
}
