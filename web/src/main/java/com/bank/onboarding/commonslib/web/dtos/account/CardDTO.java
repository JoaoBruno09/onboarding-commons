package com.bank.onboarding.commonslib.web.dtos.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CardDTO {
    private double cardAnnualFee;
    private int cardCvc;
    private String cardNumber;
    private String cardType;
}
