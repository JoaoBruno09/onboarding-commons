package com.bank.onboarding.commonslib.utils.kafka;

import com.bank.onboarding.commonslib.web.dtos.account.AccountRefDTO;
import com.bank.onboarding.commonslib.web.dtos.customer.CustomerRefDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorEvent {
    AccountRefDTO accountRefDTO;
    CustomerRefDTO customerRefDTO;
}
