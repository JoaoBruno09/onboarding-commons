package com.bank.onboarding.commonslib.persistence.services.impl;

import com.bank.onboarding.commonslib.persistence.models.Intervention;
import com.bank.onboarding.commonslib.persistence.repositories.InterventionRepository;
import com.bank.onboarding.commonslib.persistence.services.InterventionRepoService;
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
public class InterventionRepoServiceImpl implements InterventionRepoService {

    private final InterventionRepository interventionRepository;

    @Override
    public List<Intervention> getAllInterventions() {
        return Optional.of(interventionRepository.findAll()).orElse(Collections.emptyList());
    }
}
