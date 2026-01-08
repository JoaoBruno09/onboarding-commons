package com.bank.onboarding.commonslib.web.dtos.customer;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomerDocumentsRequest {
    String documentType;
    String documentBase64;
}
