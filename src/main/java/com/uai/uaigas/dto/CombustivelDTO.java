package com.uai.uaigas.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.uai.uaigas.entities.Combustivel;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CombustivelDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	@NotBlank(message = "Preenchimento obrigatorio")
	private String nome;

	public CombustivelDTO(Combustivel combustivel) {
		this.id = combustivel.getId();
		this.nome = combustivel.getNome();
	}

	public Combustivel toEntity() {
		return Combustivel.builder().id(id).nome(nome).build();
	}
}
