package com.bank.onboarding.commonslib.web.dtos.customer;

import lombok.Data;

@Data
public class AddressDTO {
    private String city;
    private String country;
    private String street;
    private String zip;
}
