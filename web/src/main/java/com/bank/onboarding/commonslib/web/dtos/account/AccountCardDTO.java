package com.bank.onboarding.commonslib.web.dtos.account;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AccountCardDTO {
    private String cardType;
    private List<String> customerNumber;
    private Integer accountPhase;
}
