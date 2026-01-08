package com.bank.onboarding.commonslib.web.dtos.customer;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CreateIntervenientDTO {
    @NotNull
    private CustomerRequestDTO intervenient;
    @NotNull
    private int accountPhase;
    @NotEmpty
    private String accountNumber;
}
