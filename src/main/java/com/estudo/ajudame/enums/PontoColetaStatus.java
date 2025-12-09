package com.estudo.ajudame.enums;

import lombok.Getter;

@Getter
public enum PontoColetaStatus {
    ABERTO("aberto"),
    FECHADO("fechado");

    private final String value;

    PontoColetaStatus(String value) {
        this.value = value;
    }

}
