package com.bank.onboarding.commonslib.web.dtos.account;

import com.bank.onboarding.commonslib.web.dtos.customer.IntervenientRequestDTO;
import lombok.Data;

@Data
public class CreateAccountRequestDTO {
    String accountManager;
    String accountType;
    IntervenientRequestDTO customerIntervenient;
}
