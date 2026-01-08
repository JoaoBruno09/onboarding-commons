package com.bank.onboarding.commonslib.web.dtos.customer;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class DocumentIdDTO {
    @NotEmpty
    private String documentIdCountry;
    @NotEmpty
    private String documentIdNumber;
    @NotEmpty
    private String documentIdType;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime documentIdExpirationDate;
}
