package com.bank.onboarding.commonslib.persistence.services;

import com.bank.onboarding.commonslib.persistence.models.Relation;

import java.util.List;

public interface RelationRepoService {
    List<Relation> getAllRelations();
}
