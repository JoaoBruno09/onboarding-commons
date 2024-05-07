package com.bank.onboarding.commonslib.persistence.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@org.springframework.data.mongodb.core.mapping.Document(collection = "documents")
@Data
@AllArgsConstructor
public class Document {
    @Id
    private String id;
    private String documentName;
    private String documentType;
    private String documentBase64;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime uploadedTime;
    private String accountId;
    private String customerId;

}
