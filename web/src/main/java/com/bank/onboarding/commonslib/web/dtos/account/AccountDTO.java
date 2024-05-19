package com.bank.onboarding.commonslib.web.dtos.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AccountDTO {
    private String accountManager;
    private String currencyCode;
    private String iban;
    private String number;
    private Boolean onlineBankingIndicator;
    private Integer phase;
    private String type;
}
