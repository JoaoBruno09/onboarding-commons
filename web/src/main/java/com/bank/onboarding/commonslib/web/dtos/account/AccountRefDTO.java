package com.bank.onboarding.commonslib.web.dtos.account;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Builder
public class AccountRefDTO {
    private String accountNumber;
}
