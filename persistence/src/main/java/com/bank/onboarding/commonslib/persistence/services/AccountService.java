package com.bank.onboarding.commonslib.persistence.services;

import com.bank.onboarding.commonslib.persistence.models.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccounts();
}
