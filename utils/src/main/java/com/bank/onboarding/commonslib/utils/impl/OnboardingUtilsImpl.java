package com.bank.onboarding.commonslib.utils.impl;

import com.bank.onboarding.commonslib.persistence.enums.OperationType;
import com.bank.onboarding.commonslib.persistence.exceptions.OnboardingException;
import com.bank.onboarding.commonslib.utils.OnboardingUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.Objects;
import java.util.Optional;

import static com.bank.onboarding.commonslib.persistence.constants.OnboardingConstants.ACCOUNT_PHASES;
import static com.bank.onboarding.commonslib.persistence.constants.OnboardingConstants.EMPRESA_ACCOUNT_TYPES;
import static com.bank.onboarding.commonslib.persistence.constants.OnboardingConstants.MINOR_ACCOUNT_TYPES;
import static com.bank.onboarding.commonslib.persistence.constants.OnboardingConstants.PARTICULAR_ACCOUNT_TYPES;
import static com.bank.onboarding.commonslib.persistence.constants.OnboardingConstants.STUDENT_ACCOUNT_TYPES;
import static com.bank.onboarding.commonslib.persistence.enums.AccountPhase.DOCS;
import static com.bank.onboarding.commonslib.persistence.enums.AccountPhase.INTYPE;
import static com.bank.onboarding.commonslib.persistence.enums.AccountPhase.RELCARD;
import static com.bank.onboarding.commonslib.persistence.enums.InterventionType.AD;
import static com.bank.onboarding.commonslib.persistence.enums.InterventionType.TT;


@Service
@Transactional
@RequiredArgsConstructor
public class OnboardingUtilsImpl implements OnboardingUtils {

    @Override
    public boolean isEmpresaAccountType(String accountType) {
        return EMPRESA_ACCOUNT_TYPES.contains(accountType);
    }

    @Override
    public boolean isParticularAccountType(String accountType) {
        return PARTICULAR_ACCOUNT_TYPES.contains(accountType);
    }

    @Override
    public boolean isMinorAndHasProgenitorOrTutorAndAccountTypeIsJOV(int age, String customerType) {
        return age < 17 && MINOR_ACCOUNT_TYPES.contains(customerType);
    }

    @Override
    public boolean isMajorAndUniversityStudentAndAccountTypeIsUNIV(Integer age, String customerProfession, String customerType) {
        return age >= 17 && "Estudante Universitário".equals(Optional.ofNullable(customerProfession).orElse("")) &&
                STUDENT_ACCOUNT_TYPES.contains(customerType);
    }

    @Override
    public int calculateAge(LocalDateTime birthDate) {
        return Period.between(birthDate.toLocalDate(), LocalDateTime.now().toLocalDate()).getYears();
    }

    @Override
    public boolean isValidPhase(Integer requestPhase, OperationType operationType) {
        if(!ACCOUNT_PHASES.contains(requestPhase)) throw new OnboardingException("Introduziu uma fase inválida.");

        switch (operationType){
            case ADD_INTERVENIENT, TYPE_ACCOUNT -> {
                if(!Objects.equals(INTYPE.getValue(), requestPhase)) throwInvalidPhaseForOperationTypeException();
            }
            case ADD_REL, CARD_ACCOUNT, NETBANCO_ACCOUNT ->{
                if(!Objects.equals(RELCARD.getValue(), requestPhase)) throwInvalidPhaseForOperationTypeException();
            }
            case UPDATE_CUSTOMER -> {
                if(!Objects.equals(INTYPE.getValue(), requestPhase) ||
                        !Objects.equals(RELCARD.getValue(), requestPhase)) throwInvalidPhaseForOperationTypeException();
            }
            case DOCS_UPLOAD -> {
                if(!Objects.equals(DOCS.getValue(), requestPhase)) throwInvalidPhaseForOperationTypeException();
            }
        }

        return true;
    }

    @Override
    public String getInterventionTypeValue(String interventionType) {
        String interventionTypeToBeReturned = null;
        if(TT.name().equals(interventionType)){
            interventionTypeToBeReturned = TT.getValue();
        } else if (AD.getValue().equals(interventionType)) {
            interventionTypeToBeReturned = AD.getValue();
        }

        return interventionTypeToBeReturned;
    }

    @Override
    public String getDocumentTypeValue(String documentType) {
        return null;
    }

    private void throwInvalidPhaseForOperationTypeException(){
        throw new OnboardingException("Não é possível efetuar esta operação porque fase introduzida é inválida");
    }
}
