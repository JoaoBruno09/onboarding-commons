package com.bank.onboarding.commonslib.web.dtos.account;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountNetbancoDTO {
    @NotEmpty
    private boolean wantsNetbanco;
    @NotEmpty
    private int accountPhase;
    @NotEmpty
    private String customerNumber;
}
