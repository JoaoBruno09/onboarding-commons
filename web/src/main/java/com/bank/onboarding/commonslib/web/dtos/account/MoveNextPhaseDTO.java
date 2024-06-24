package com.bank.onboarding.commonslib.web.dtos.account;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MoveNextPhaseDTO {
    @NotEmpty
    private int nextPhase;
}
