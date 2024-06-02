package com.bank.onboarding.commonslib.utils.kafka.models;

import com.bank.onboarding.commonslib.web.dtos.customer.CustomerRefDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CardAndNetbancoEvent {
    boolean value;
    CustomerRefDTO customerRefDTO;
}
