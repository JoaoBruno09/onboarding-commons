package com.bank.onboarding.commonslib.web.dtos.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CardDTO {
    private double annualFee;
    private int cvc;
    private String number;
    private String type;
}
