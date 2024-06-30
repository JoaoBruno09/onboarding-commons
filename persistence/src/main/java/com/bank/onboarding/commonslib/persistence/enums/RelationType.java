package com.bank.onboarding.commonslib.persistence.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RelationType {
    DTOC("Direção de Topo e/ou Outro tipo de Controlo"),
    P("Participante"),
    RL("Representante Legal"),
    R("Representado"),
    G("Gerente"),
    AD("Adminitrador"),
    V("Vogal"),
    MD("Membro Dirigente"),
    S("Sócio"),
    SG("Sócio-Gerente"),
    A("Acionista"),
    PR("Presidente"),
    IE("Interveniente Estatuário"),
    D("Diretor"),
    MC("Membro Consórcio"),
    AI("Administrador de Insolvência");

    private final String value;
}
