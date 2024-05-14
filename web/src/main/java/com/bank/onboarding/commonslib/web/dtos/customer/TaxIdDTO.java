package com.bank.onboarding.commonslib.web.dtos.customer;

import lombok.Data;

@Data
public class TaxIdDTO {
    private String taxIdCountry;
    private String taxIdNumber;
    private String taxIdType;
}
