package com.bank.onboarding.commonslib.persistence.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DocumentType {
    CC("Cartão de Cidadão"),
    BI("Bilhete de Identidade"),
    DI("Documento de Identificação"),
    DIF("Documento de Identificação Fiscal"),
    CM("Comprovativo de Morada"),
    CPEP("Comprovativo Profissão e Entidade Patronal"),
    FAC("Ficha de Abertura de Conta"),
    FIN("Ficha de Informação Normalizada");

    private final String value;

}
