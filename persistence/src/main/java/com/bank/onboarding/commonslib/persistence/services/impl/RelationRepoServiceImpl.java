package com.bank.onboarding.commonslib.persistence.services.impl;

import com.bank.onboarding.commonslib.persistence.models.Relation;
import com.bank.onboarding.commonslib.persistence.repositories.RelationRepository;
import com.bank.onboarding.commonslib.persistence.services.RelationRepoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Transactional
@Service
@RequiredArgsConstructor
public class RelationRepoServiceImpl implements RelationRepoService {

    private final RelationRepository relationRepository;

    @Override
    public List<Relation> getAllRelationsByCustomerId(String customerId) {
        return Optional.of(relationRepository.findAllByFatherId(customerId)).orElse(Collections.emptyList());
    }

    @Override
    public void saveRelationDB(Relation relation) {
        relationRepository.save(relation);
    }
}
