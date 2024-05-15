package com.bank.onboarding.commonslib.web.dtos.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CardDTO {
    private Double cardAnnualFee;
    private Integer cardCvc;
    private String cardNumber;
    private String cardType;
}
