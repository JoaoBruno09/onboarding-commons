package com.bank.onboarding.commonslib.web.dtos.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AccountDTO {
    private String accountManager;
    private String accountCurrencyCode;
    private String accountIban;
    private String accountNumber;
    private Boolean accountOnlineBankingIndicator;
    private String accountType;
}
