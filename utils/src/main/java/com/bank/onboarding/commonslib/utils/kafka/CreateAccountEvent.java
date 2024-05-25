package com.bank.onboarding.commonslib.utils.kafka;

import com.bank.onboarding.commonslib.web.dtos.account.AccountRefDTO;
import com.bank.onboarding.commonslib.web.dtos.account.CreateAccountRequestDTO;
import com.bank.onboarding.commonslib.web.dtos.customer.CustomerRefDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateAccountEvent {
    CreateAccountRequestDTO createAccountRequestDTO;
    AccountRefDTO accountRefDTO;
    CustomerRefDTO customerRefDTO;
}
