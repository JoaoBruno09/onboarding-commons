package com.bank.onboarding.commonslib.utils.kafka.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocUploadEvent {
    String accountNumber;
    String customerNumber;
    boolean areDocsValid;
}
