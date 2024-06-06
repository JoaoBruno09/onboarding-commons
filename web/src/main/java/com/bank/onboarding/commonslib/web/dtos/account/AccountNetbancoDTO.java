package com.bank.onboarding.commonslib.web.dtos.account;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountNetbancoDTO {
    @NotNull
    private boolean wantsNetbanco;
    @NotNull
    private int accountPhase;
    @NotNull
    @NotBlank
    private String customerNumber;
}
