package com.bank.onboarding.commonslib.persistence.services.impl;

import com.bank.onboarding.commonslib.persistence.exceptions.OnboardingException;
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
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@Transactional
@Service
@RequiredArgsConstructor
public class InterventionRepoServiceImpl implements InterventionRepoService {

    private final InterventionRepository interventionRepository;

    @Override
    public List<Intervention> getAllInterventionsByCustomerNumber(String customerNumber) {
        return Optional.of(interventionRepository.findAllByCustomerNumber(customerNumber)).orElse(Collections.emptyList());
    }

    @Override
    public Intervention saveInterventionDB(Intervention intervention) {
        AtomicReference<Intervention> interventionToBeReturned = new AtomicReference<>();
        Optional.of(interventionRepository.save(intervention)).ifPresentOrElse(interventionToBeReturned::set, () -> {
            throw new OnboardingException("Ocorreu um erro a guardar a intervenção na base de dados.");
        } );

        return interventionToBeReturned.get();
    }

    @Override
    public void findAndDeleteInterventionByAccountNumber(String accountNumber) {
        Optional.ofNullable(interventionRepository.findByAccountNumber(accountNumber)).ifPresent(intervention ->
                interventionRepository.deleteById(intervention.getId()));
    }

    @Override
    public Intervention getInterventionByInterventionId(String interventionId) {
        return Optional.of(interventionRepository.findById(interventionId)).get().orElse(null);
    }

    @Override
    public void deleteIntervention(Intervention intervention) {
        interventionRepository.delete(intervention);
    }
}
