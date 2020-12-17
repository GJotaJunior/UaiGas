package com.uai.uaigas.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ReclamacaoStatus {
    
    AGUARDANDO(1), PROCESSADA(2);

    @Getter
    private int codigo;
    
}
