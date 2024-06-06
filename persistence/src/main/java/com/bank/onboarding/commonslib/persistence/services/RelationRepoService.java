package com.bank.onboarding.commonslib.persistence.services;

import com.bank.onboarding.commonslib.persistence.models.Relation;

import java.util.List;

public interface RelationRepoService {
    List<Relation> getAllRelationsByCustomerId(String customerId);
    void saveRelationDB(Relation relation);
    Relation getRelationByRelationId(String relationId);
    void deleteRelation(Relation relation);
}
