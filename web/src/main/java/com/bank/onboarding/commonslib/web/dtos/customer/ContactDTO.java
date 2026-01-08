package com.bank.onboarding.commonslib.web.dtos.customer;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContactDTO {
    @NotEmpty
    private String type;
    @NotEmpty
    private String value;
}
