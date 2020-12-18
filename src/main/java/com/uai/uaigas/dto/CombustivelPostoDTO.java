package com.uai.uaigas.dto;

import java.io.Serializable;

import com.uai.uaigas.entities.Combustivel;
import com.uai.uaigas.entities.CombustivelPosto;
import com.uai.uaigas.entities.Cotacao;
import com.uai.uaigas.entities.Posto;
import com.uai.uaigas.entities.TipoCombustivel;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CombustivelPostoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private TipoCombustivel tipoCombustivel;
	private Combustivel combustivel;
	private Cotacao cotacao;
	private Posto posto;

	public CombustivelPostoDTO(CombustivelPosto combustivelPosto) {
		this.id = combustivelPosto.getId();
		this.nome = combustivelPosto.getNome();
		this.tipoCombustivel = combustivelPosto.getTipo();
		this.combustivel = combustivelPosto.getCombustivel();
		this.cotacao = combustivelPosto.getCotacao();
		this.posto = combustivelPosto.getPosto();
	}

	public CombustivelPosto toEntity() {
		return CombustivelPosto.builder().id(id).nome(nome).tipo(tipoCombustivel).cotacao(cotacao).posto(posto).combustivel(combustivel).build();
	}
}
