package com.uai.uaigas.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.uai.uaigas.entities.TipoCombustivel;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TipoCombustivelDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	@NotBlank(message = "Preenchimento obrigatorio")
	private String descricao;

	public TipoCombustivelDTO(TipoCombustivel tipoCombustivel) {
		this.id = tipoCombustivel.getId();
		this.descricao = tipoCombustivel.getDescricao();
	}

	public TipoCombustivel toEntity() {
		return TipoCombustivel.builder().id(id).descricao(descricao).build();
	}
}
