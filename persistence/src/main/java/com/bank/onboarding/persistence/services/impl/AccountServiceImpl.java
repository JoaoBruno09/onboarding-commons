package com.bank.onboarding.persistence.services.impl;

import com.bank.onboarding.persistence.models.Account;
import com.bank.onboarding.persistence.repositories.AccountRepository;
import com.bank.onboarding.persistence.services.AccountService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Slf4j
@Transactional
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public List<Account> getAllAccounts() {
        accountRepository.findAll().forEach(account -> {
            try {
                log.info(new ObjectMapper().writeValueAsString(account));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
        return Collections.emptyList();
    }
}
