package com.bank.onboarding.commonslib.web.dtos.customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CreateIntervenientDTO {
    @NotNull
    CustomerRequestDTO intervenient;
    @NotNull
    int accountPhase;
    @NotBlank
    @NotNull
    String accountNumber;
}
