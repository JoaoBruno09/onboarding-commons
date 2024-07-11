package com.bank.onboarding.commonslib.web.dtos.document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UploadDocumentRequestDTO {
    @NotBlank
    @NotNull
    String documentType;
    @NotBlank
    @NotNull
    String documentBase64;
    @NotBlank
    @NotNull
    String customerNumber;
    @NotBlank
    @NotNull
    String accountNumber;
    @NotNull
    int accountPhase;
}
