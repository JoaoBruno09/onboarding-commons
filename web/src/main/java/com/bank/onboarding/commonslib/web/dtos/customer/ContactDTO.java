package com.bank.onboarding.commonslib.web.dtos.customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContactDTO {
    private String type;
    private String value;
}
