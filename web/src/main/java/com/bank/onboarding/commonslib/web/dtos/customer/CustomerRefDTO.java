package com.bank.onboarding.commonslib.web.dtos.customer;

import com.bank.onboarding.commonslib.persistence.models.identifiers.AccountIdentifier;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CustomerRefDTO {
    private String customerNumber;
    private Boolean isValid;
    private List<AccountIdentifier> accounts;
}
