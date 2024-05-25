package com.bank.onboarding.commonslib.web.dtos.customer;

import lombok.Data;

@Data
public class CustomerDocumentsRequest {
    String documentType;
    String documentBase64;
}
