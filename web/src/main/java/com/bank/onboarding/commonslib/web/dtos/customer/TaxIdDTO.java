package com.bank.onboarding.commonslib.web.dtos.customer;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaxIdDTO {
    @NotEmpty
    private String taxIdCountry;
    @NotEmpty
    private String taxIdNumber;
    @NotEmpty
    private String taxIdType;
}
