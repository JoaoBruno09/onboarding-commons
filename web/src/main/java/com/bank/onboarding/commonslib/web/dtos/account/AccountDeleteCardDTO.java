package com.bank.onboarding.commonslib.web.dtos.account;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class AccountDeleteCardDTO {
    @NotNull
    private int accountPhase;
    @NotBlank
    @NotNull
    private String customerNumber;
}
