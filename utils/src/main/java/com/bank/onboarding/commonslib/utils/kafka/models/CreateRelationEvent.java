package com.bank.onboarding.commonslib.utils.kafka.models;

import com.bank.onboarding.commonslib.web.dtos.account.AccountRefDTO;
import com.bank.onboarding.commonslib.web.dtos.customer.CreateRelationDTO;
import com.bank.onboarding.commonslib.web.dtos.customer.CustomerRefDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class CreateRelationEvent {
    CreateRelationDTO createRelationDTO;
    CustomerRefDTO customerRefDTO;
    AccountRefDTO accountRefDTO;
}
