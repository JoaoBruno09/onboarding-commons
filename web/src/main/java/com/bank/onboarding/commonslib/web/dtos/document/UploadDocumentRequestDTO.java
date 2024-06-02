package com.bank.onboarding.commonslib.web.dtos.document;

import lombok.Data;

@Data
public class UploadDocumentRequestDTO {
    String documentType;
    String documentBase64;
    String customerNumber;
    String accountNumber;
    int accountPhase;
}
