package com.bank.onboarding.commonslib.persistence.services.impl;

import com.bank.onboarding.commonslib.persistence.exceptions.OnboardingException;
import com.bank.onboarding.commonslib.persistence.models.AccountRef;
import com.bank.onboarding.commonslib.persistence.repositories.AccountRefRepository;
import com.bank.onboarding.commonslib.persistence.services.AccountRefRepoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Transactional
@Service
@RequiredArgsConstructor
public class AccountRefRepoServiceImpl implements AccountRefRepoService {

    private final AccountRefRepository accountRefRepository;
    @Override
    public void saveAccountRefDB(AccountRef accountRef) {
        Optional.of(accountRefRepository.save(accountRef)).orElseThrow(() ->
                new OnboardingException("Ocorreu um erro a guardar a conta na base de dados."));
    }

    @Override
    public void deleteAccountById(String accountId) {
        accountRefRepository.deleteById(accountId);
    }
}
