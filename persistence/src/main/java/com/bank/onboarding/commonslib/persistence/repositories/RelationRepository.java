package com.bank.onboarding.commonslib.persistence.repositories;

import com.bank.onboarding.commonslib.persistence.models.Relation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RelationRepository extends MongoRepository<Relation, String> {
}
