package com.bank.onboarding.commonslib.web.dtos.account;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MoveNextPhaseDTO {
    private int nextPhase;

    @JsonCreator
    public MoveNextPhaseDTO(@JsonProperty("nextPhase") int nextPhase) {
        this.nextPhase = nextPhase;
    }
}
