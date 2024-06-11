package com.bank.onboarding.commonslib.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class ErrorResponseDTO {
    String httpMethod;
    int httpResponseStatus;
    String errorMessage;
}
