package com.bank.onboarding.commonslib.web.dtos.document;

import lombok.Data;

@Data
public class DeleteDocumentRequestDTO {
    String documentType;
    String customerNumber;
    String accountNumber;
    int accountPhase;
}
