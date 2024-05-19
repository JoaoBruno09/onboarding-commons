package com.bank.onboarding.commonslib.web.dtos.customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaxIdDTO {
    private String taxIdCountry;
    private String taxIdNumber;
    private String taxIdType;
}
