package com.bank.onboarding.commonslib.web.dtos.document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DeleteDocumentRequestDTO {
    @NotBlank
    @NotNull
    String documentType;
    String customerNumber;
    String accountNumber;
    @NotNull
    int accountPhase;
}
