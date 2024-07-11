package com.bank.onboarding.commonslib.web.dtos.account;

import com.bank.onboarding.commonslib.web.dtos.customer.CustomerRequestDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateAccountRequestDTO {
    @NotBlank
    @NotNull
    String accountManager;
    @NotBlank
    @NotNull
    String accountType;
    @NotNull
    CustomerRequestDTO customerIntervenient;
}
