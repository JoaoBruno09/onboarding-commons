package com.bank.onboarding.commonslib.web.dtos.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CreateIntervenientDTO {
    String customerNumber;
    IntervenientRequestDTO intervenient;
    int accountPhase;
    String accountNumber;
}
