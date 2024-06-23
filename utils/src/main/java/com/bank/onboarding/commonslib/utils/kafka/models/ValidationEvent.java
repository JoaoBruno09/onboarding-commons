package com.bank.onboarding.commonslib.utils.kafka.models;

import com.bank.onboarding.commonslib.persistence.enums.ValidationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class ValidationEvent {
    ValidationType validationType;
    String accountId;
}
