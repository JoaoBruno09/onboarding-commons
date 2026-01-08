package com.bank.onboarding.commonslib.web.dtos.customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CreateRelationDTO {
    @NotNull
    @NotBlank
    String childCustomerNumber;
    @NotNull
    CustomerRequestDTO parentCustomer;
    @NotNull
    int accountPhase;
    @NotNull
    @NotBlank
    String accountNumber;
}
