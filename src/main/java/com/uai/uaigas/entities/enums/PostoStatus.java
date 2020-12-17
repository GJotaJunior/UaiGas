package com.uai.uaigas.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum PostoStatus {

    ATIVO(1), INATIVO(2), BLOQUEADO(3);

    @Getter
    private int codigo;
    
    public static PostoStatus valueOf(int codigo) {
	for (PostoStatus posto : PostoStatus.values()) {
	    if (posto.getCodigo() == codigo) {
		return posto;
	    }
	}
	throw new IllegalArgumentException("Código de Posto Status inválido!");
    }
}
