package com.bank.onboarding.commonslib.persistence.constants;

import com.bank.onboarding.commonslib.persistence.enums.DocumentType;
import com.bank.onboarding.commonslib.persistence.enums.RelationType;
import com.github.javafaker.Faker;

import java.util.List;
import java.util.Locale;

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
import static com.bank.onboarding.commonslib.persistence.enums.DocumentType.CM;
import static com.bank.onboarding.commonslib.persistence.enums.DocumentType.CPEP;
import static com.bank.onboarding.commonslib.persistence.enums.DocumentType.DI;
import static com.bank.onboarding.commonslib.persistence.enums.DocumentType.DIF;
import static com.bank.onboarding.commonslib.persistence.enums.DocumentType.FAC;
import static com.bank.onboarding.commonslib.persistence.enums.DocumentType.FIN;
import static com.bank.onboarding.commonslib.persistence.enums.InterventionType.AD;
import static com.bank.onboarding.commonslib.persistence.enums.InterventionType.TT;
import static com.bank.onboarding.commonslib.persistence.enums.RelationType.D;
import static com.bank.onboarding.commonslib.persistence.enums.RelationType.G;
import static com.bank.onboarding.commonslib.persistence.enums.RelationType.PC;
import static com.bank.onboarding.commonslib.persistence.enums.RelationType.PG;
import static com.bank.onboarding.commonslib.persistence.enums.RelationType.SG;

public class OnboardingConstants {
    public static final List<String> PARTICULAR_ACCOUNT_TYPES = List.of(ORDEM.name(),BASE.name(), SMB.name(), POUPANCA.name(), ORDENADO.name());
    public static final List<String> EMPRESA_ACCOUNT_TYPES = List.of(EMP.name());
    public static final List<String> MINOR_ACCOUNT_TYPES = List.of(JOV.name());
    public static final List<String> STUDENT_ACCOUNT_TYPES = List.of(UNIV.name());
    public static final List<String> ACCOUNT_TYPES = List.of(ORDEM.name(),BASE.name(), SMB.name(), POUPANCA.name(), ORDENADO.name(), EMP.name(), JOV.name(), UNIV.name());
    public static final List<String> CARD_TYPES = List.of(CD.name(), CC.name(), CDD.name(), CPP.name(), CDM.name());
    public static final List<Integer> ACCOUNT_PHASES = List.of(INTYPE.getValue(), RELCARD.getValue(), DOCS.getValue(),TERMINADA.getValue());
    public static final List<String> CONTACT_TYPES = List.of(TELEPHONE.name(), EMAIL.name());
    public static final List<String> DOCUMENT_TYPES_CREATE_ACCOUNT_REQUEST = List.of(DocumentType.CC.name(), BI.name(), DI.name(), DIF.name());
    public static final List<String> DOCUMENT_TYPES_PHASE_3_CUSTOMER = List.of(CM.name(), CPEP.name());
    public static final List<String> DOCUMENT_TYPES_PHASE_3_ACCOUNT = List.of(FAC.name(), FIN.name());
    public static final List<String> CUSTOMER_TYPES = List.of(PARTICULAR.name(), EMPRESA.name());
    public static final List<String> INTERVENTIONS_TYPES = List.of(TT.name(), AD.name());
    public static final List<String> RELATION_TYPES = List.of(RelationType.TT.name(), PG.name(), PC.name(), RelationType.AD.name(), G.name(), D.name(), RelationType.CC.name(), SG.name());
    public static final Faker faker = new Faker(new Locale("pt"));
}
