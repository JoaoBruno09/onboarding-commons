package com.bank.onboarding.commonslib.utils.kafka.models;

import com.bank.onboarding.commonslib.web.dtos.account.AccountRefDTO;
import com.bank.onboarding.commonslib.web.dtos.customer.CreateIntervenientDTO;
import com.bank.onboarding.commonslib.web.dtos.customer.CustomerRefDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class CreateIntervenientEvent {
    CreateIntervenientDTO createIntervenientDTO;
    boolean newCustomer;
    CustomerRefDTO customerRefDTO;
    AccountRefDTO accountRefDTO;
}
