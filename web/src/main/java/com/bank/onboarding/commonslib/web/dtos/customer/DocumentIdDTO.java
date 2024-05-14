package com.bank.onboarding.commonslib.web.dtos.customer;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DocumentIdDTO {
    private String documentIdCountry;
    private String documentIdNumber;
    private String documentIdType;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime documentIdExpirationDate;
}
