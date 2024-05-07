package com.bank.onboarding.commonslib.persistence.repositories;

import com.bank.onboarding.commonslib.persistence.models.Intervention;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InterventionRepository extends MongoRepository<Intervention, String> {
}
