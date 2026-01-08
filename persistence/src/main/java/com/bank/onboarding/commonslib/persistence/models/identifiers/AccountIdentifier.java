package com.bank.onboarding.commonslib.persistence.models.identifiers;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountIdentifier {
    private String accountNumber;

    @JsonCreator
    public AccountIdentifier(@JsonProperty("accountNumber") String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
