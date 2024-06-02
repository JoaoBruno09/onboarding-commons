package com.bank.onboarding.commonslib.web.dtos.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class DocumentDTO {
    String documentName;
    String documentType;
    String documentBase64;
}
