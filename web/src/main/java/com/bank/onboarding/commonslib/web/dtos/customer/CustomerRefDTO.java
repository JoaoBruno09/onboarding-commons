package com.bank.onboarding.commonslib.web.dtos.customer;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class CustomerRefDTO {
    @Id
    private String customerId;
    private String customerNumber;
}
