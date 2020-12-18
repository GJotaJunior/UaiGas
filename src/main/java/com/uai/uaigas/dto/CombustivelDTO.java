package com.uai.uaigas.dto;

import java.io.Serializable;

import com.uai.uaigas.entities.Combustivel;
import com.uai.uaigas.entities.Cotacao;
import com.uai.uaigas.entities.Posto;
import com.uai.uaigas.entities.TipoCombustivel;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CombustivelDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private TipoCombustivel tipoCombustivel;
	private Cotacao cotacao;
	private Posto posto;

	public CombustivelDTO(Combustivel combustivel) {
		this.id = combustivel.getId();
		this.nome = combustivel.getNome();
		this.tipoCombustivel = combustivel.getTipo();
		this.cotacao = combustivel.getCotacao();
		this.posto = combustivel.getPosto();
	}

	public Combustivel toEntity() {
		return Combustivel.builder().id(id).nome(nome).tipo(tipoCombustivel).cotacao(cotacao).posto(posto).build();
	}
}
