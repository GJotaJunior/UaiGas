package com.uai.uaigas.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	@NotBlank(message = "Preenchimento obrigatorio")
	private String nome;
	@NotNull
	private TipoCombustivel tipoCombustivel;
	@NotNull
	private Combustivel combustivel;
	@NotNull
	private Cotacao cotacao;
	@NotNull
	private Posto posto;

	public CombustivelPostoDTO(CombustivelPosto combustivelPosto) {
		this.id = combustivelPosto.getId();
		this.tipoCombustivel = combustivelPosto.getTipo();
		this.combustivel = combustivelPosto.getCombustivel();
		this.cotacao = combustivelPosto.getCotacao();
		this.posto = combustivelPosto.getPosto();
	}

	public CombustivelPosto toEntity() {
		return CombustivelPosto.builder().id(id).tipo(tipoCombustivel).cotacao(cotacao).posto(posto).combustivel(combustivel).build();
	}
}
