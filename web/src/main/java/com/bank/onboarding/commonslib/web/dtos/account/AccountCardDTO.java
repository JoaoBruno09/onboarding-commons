package com.bank.onboarding.commonslib.web.dtos.account;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AccountCardDTO {
    @NotBlank
    @NotNull
    private String cardType;
    @NotEmpty
    private List<String> customerNumber;
    @NotNull
    private int accountPhase;
}
