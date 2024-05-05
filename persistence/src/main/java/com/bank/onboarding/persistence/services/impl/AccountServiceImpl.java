package com.bank.onboarding.persistence.services.impl;

import com.bank.onboarding.persistence.models.Account;
import com.bank.onboarding.persistence.repositories.AccountRepository;
import com.bank.onboarding.persistence.services.AccountService;
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
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public List<Account> getAllAccounts() {
        return Optional.of(accountRepository.findAll()).orElse(Collections.emptyList());
    }
}
