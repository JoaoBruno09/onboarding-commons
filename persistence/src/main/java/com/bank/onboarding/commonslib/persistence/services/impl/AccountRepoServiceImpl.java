package com.bank.onboarding.commonslib.persistence.services.impl;

import com.bank.onboarding.commonslib.persistence.exceptions.OnboardingException;
import com.bank.onboarding.commonslib.persistence.models.Account;
import com.bank.onboarding.commonslib.persistence.repositories.AccountRepository;
import com.bank.onboarding.commonslib.persistence.services.AccountRepoService;
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
public class AccountRepoServiceImpl implements AccountRepoService {

    private final AccountRepository accountRepository;

    @Override
    public List<Account> findAccountsDB() {
        return Optional.of(accountRepository.findAll()).orElse(Collections.emptyList());
    }

    @Override
    public Account getAccountByNumber(String accountNumber) throws OnboardingException {
        return Optional.ofNullable(accountRepository.findByNumber(accountNumber)).orElseThrow(() ->
                new OnboardingException("Não foi encontrada nenhuma conta com o número " + accountNumber));
    }

    @Override
    public Account saveAccountDB(Account account) throws OnboardingException {
        AtomicReference<Account> accountToBeReturned = new AtomicReference<>();
        Optional.of(accountRepository.save(account)).ifPresentOrElse(accountToBeReturned::set, () -> {
            throw new OnboardingException("Ocorreu um erro a guardar a conta na base de dados.");
        } );

        return accountToBeReturned.get();
    }

    @Override
    public void deleteAccountById(String accountId) {
        accountRepository.deleteById(accountId);
    }

    @Override
    public Account getAccountById(String accountId) {
        return Optional.of(accountRepository.findById(accountId)).get().orElseThrow(() ->
                new OnboardingException("Não foi encontrada nenhuma conta"));
    }
}
