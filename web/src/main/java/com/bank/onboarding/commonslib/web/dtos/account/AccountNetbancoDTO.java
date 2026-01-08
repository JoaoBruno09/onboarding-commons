package com.bank.onboarding.commonslib.web.dtos.account;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class AccountNetbancoDTO {
    private boolean wantsNetbanco;
    private int accountPhase;
    @NotEmpty
    private String customerNumber;
}
