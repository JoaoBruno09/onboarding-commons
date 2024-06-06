package com.bank.onboarding.commonslib.web.dtos.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CreateRelationDTO {
    String childCustomerNumber;
    CustomerRequestDTO parentCustomer;
    int accountPhase;
    String accountNumber;
}
