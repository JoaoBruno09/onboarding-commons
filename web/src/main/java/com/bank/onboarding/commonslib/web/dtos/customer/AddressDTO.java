package com.bank.onboarding.commonslib.web.dtos.customer;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDTO {
    @NotEmpty
    private String city;
    @NotEmpty
    private String country;
    @NotEmpty
    private String street;
    @NotEmpty
    private String zip;
}
