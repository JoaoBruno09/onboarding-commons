package com.bank.onboarding.commonslib.persistence.services.impl;

import com.bank.onboarding.commonslib.persistence.exceptions.OnboardingException;
import com.bank.onboarding.commonslib.persistence.models.Account;
import com.bank.onboarding.commonslib.persistence.repositories.AccountRepository;
import com.bank.onboarding.commonslib.persistence.services.AccountRepoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Transactional
@Service
@RequiredArgsConstructor
public class AccountRepoServiceImpl implements AccountRepoService {

    private final AccountRepository accountRepository;

    @Override
    public List<Account> findAccountsDB() {
        return Optional.of(accountRepository.findAll()).orElse(Collections.emptyList());
    }

    @Override
    public Account saveAccountTypeDB(Account account, String accountType){
        account.setType(accountType);
        if(Boolean.TRUE.equals(saveAccountDB(account))) return account;
        return null;
    }

    @Override
    public Account findAccountDB(String accountNumber) throws OnboardingException {
        return Optional.ofNullable(accountRepository.findByNumber(accountNumber)).orElseThrow(() ->
                new OnboardingException("Não foi encontrada nenhuma conta com o número " + accountNumber));
    }

    @Override
    public Boolean saveAccountDB(Account account) throws OnboardingException {
        account.setLastUpdateTime(LocalDateTime.now());
        if(accountRepository.save(account).getId() != null) return Boolean.TRUE;

        throw new OnboardingException("Ocorreu um erro a guardar a conta na base de dados.");
    }
}
