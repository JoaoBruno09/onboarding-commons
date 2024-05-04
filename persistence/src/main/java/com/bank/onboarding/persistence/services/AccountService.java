package com.bank.onboarding.persistence.services;

import com.bank.onboarding.persistence.models.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccounts();
}
