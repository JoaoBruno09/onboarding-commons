package com.bank.onboarding.commonslib.persistence.constants;

import com.bank.onboarding.commonslib.persistence.enums.DocumentType;
import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

import static com.bank.onboarding.commonslib.persistence.enums.AccountPhase.DOCS;
import static com.bank.onboarding.commonslib.persistence.enums.AccountPhase.INTYPE;
import static com.bank.onboarding.commonslib.persistence.enums.AccountPhase.RELCARD;
import static com.bank.onboarding.commonslib.persistence.enums.AccountPhase.TERMINADA;
import static com.bank.onboarding.commonslib.persistence.enums.AccountType.BASE;
import static com.bank.onboarding.commonslib.persistence.enums.AccountType.EMP;
import static com.bank.onboarding.commonslib.persistence.enums.AccountType.JOV;
import static com.bank.onboarding.commonslib.persistence.enums.AccountType.ORDEM;
import static com.bank.onboarding.commonslib.persistence.enums.AccountType.ORDENADO;
import static com.bank.onboarding.commonslib.persistence.enums.AccountType.POUPANCA;
import static com.bank.onboarding.commonslib.persistence.enums.AccountType.SMB;
import static com.bank.onboarding.commonslib.persistence.enums.AccountType.UNIV;
import static com.bank.onboarding.commonslib.persistence.enums.CardType.CC;
import static com.bank.onboarding.commonslib.persistence.enums.CardType.CD;
import static com.bank.onboarding.commonslib.persistence.enums.CardType.CDD;
import static com.bank.onboarding.commonslib.persistence.enums.CardType.CDM;
import static com.bank.onboarding.commonslib.persistence.enums.CardType.CPP;
import static com.bank.onboarding.commonslib.persistence.enums.ContactType.EMAIL;
import static com.bank.onboarding.commonslib.persistence.enums.ContactType.TELEPHONE;
import static com.bank.onboarding.commonslib.persistence.enums.CustomerType.EMPRESA;
import static com.bank.onboarding.commonslib.persistence.enums.CustomerType.PARTICULAR;
import static com.bank.onboarding.commonslib.persistence.enums.DocumentType.BI;

public class OnboardingConstants {
    public static final List<String> PARTICULAR_ACCOUNT_TYPES = List.of(ORDEM.name(),BASE.name(), SMB.name(), POUPANCA.name(), ORDENADO.name());
    public static final List<String> EMPRESA_ACCOUNT_TYPES = List.of(EMP.name());
    public static final List<String> MINOR_ACCOUNT_TYPES = List.of(JOV.name());
    public static final List<String> STUDENT_ACCOUNT_TYPES = List.of(UNIV.name());
    public static final List<String> ACCOUNT_TYPES = new ArrayList<>();
    public static final List<String> CARD_TYPES = List.of(CD.name(), CC.name(), CDD.name(), CPP.name(), CDM.name());
    public static final List<Integer> ACCOUNT_PHASES = List.of(INTYPE.getValue(), RELCARD.getValue(), DOCS.getValue(),TERMINADA.getValue());
    public static final List<String> CONTACT_TYPES = List.of(TELEPHONE.name(), EMAIL.name());
    public static final List<String> DOCUMENT_TYPES_CREATE_ACCOUNT_REQUEST = List.of(DocumentType.CC.name(), BI.name());
    public static final List<String> CUSTOMER_TYPES = List.of(PARTICULAR.name(), EMPRESA.name());

    @PostConstruct
    private void addAllAccountTypes(){
        ACCOUNT_TYPES.addAll(PARTICULAR_ACCOUNT_TYPES);
        ACCOUNT_TYPES.addAll(EMPRESA_ACCOUNT_TYPES);
        ACCOUNT_TYPES.addAll(MINOR_ACCOUNT_TYPES);
        ACCOUNT_TYPES.addAll(STUDENT_ACCOUNT_TYPES);
    }
}
