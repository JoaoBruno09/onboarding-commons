package com.bank.onboarding.commonslib.persistence.services;

import com.bank.onboarding.commonslib.persistence.models.Relation;

import java.util.List;

public interface RelationRepoService {
    List<Relation> getAllRelationsByCustomerNumber(String customerNumber);
    void saveRelationDB(Relation relation);
    Relation getRelationByRelationId(String relationId);
    void deleteRelation(Relation relation);
}
