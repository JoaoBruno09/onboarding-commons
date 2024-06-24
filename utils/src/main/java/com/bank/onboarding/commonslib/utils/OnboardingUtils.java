package com.bank.onboarding.commonslib.utils;

import com.bank.onboarding.commonslib.persistence.enums.OperationType;
import com.bank.onboarding.commonslib.persistence.models.AccountRef;
import com.bank.onboarding.commonslib.web.dtos.account.AccountRefDTO;
import com.bank.onboarding.commonslib.web.dtos.customer.CustomerRefDTO;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public interface OnboardingUtils {
    boolean isEmpresaAccountType(String accountType);
    boolean isParticularAccountType(String accountType);
    boolean isMinorAndHasProgenitorOrTutorAndAccountTypeIsJOV(int age, String customerType);
    boolean isMajorAndUniversityStudentAndAccountTypeIsUNIV(Integer age, String customerProfession, String customerType);
    int calculateAge(LocalDateTime birthDate);
    boolean isValidPhase(Integer requestPhase, OperationType operationType);
    String getInterventionTypeValue(String interventionType);
    String getDocumentTypeValue(String documentType);
    void sendErrorEvent(String topicName, AccountRefDTO accountRefDTO, CustomerRefDTO customerRefDTO, OperationType operationType);
    void sendErrorEvent(String topicName, AccountRefDTO accountRefDTO, CustomerRefDTO customerRefDTO, OperationType operationType, Boolean isNewCustomer);
    AccountRef verifyIfAccountExists(String accountNumber);
    String getRelationTypeValue(String relationType);
    ResponseEntity<?> buildResponseEntity(String httpMethod, String message);

    void throwInvalidPhaseForOperationTypeException();
}
