package com.bank.onboarding.commonslib.web.dtos.account;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class AccountRefDTO {

    private String accountNumber;

    @JsonCreator
    public AccountRefDTO(@JsonProperty("accountNumber") String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
