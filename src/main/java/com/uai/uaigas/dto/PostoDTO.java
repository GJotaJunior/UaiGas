package com.uai.uaigas.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.uai.uaigas.entities.CombustivelPosto;
import com.uai.uaigas.entities.Posto;
import com.uai.uaigas.entities.Reclamacao;
import com.uai.uaigas.entities.enums.PostoStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostoDTO {
	private Long id;
	@NotBlank(message = "Preenchimento obrigatorio")
	private String descricao;
	@NotNull
	private PostoStatus status;
	private List<Reclamacao> reclamacoes;
	private List<CombustivelPosto> combustiveis;

	public PostoDTO(Posto posto) {
		this.id = posto.getId();
		this.descricao = posto.getDescricao();
		this.status = posto.getStatus();
		this.reclamacoes = posto.getReclamacoes();
		this.combustiveis = posto.getCombustiveis();
	}

	public Posto toEntity() {
		return Posto.builder().id(id).descricao(descricao).status(status).reclamacoes(reclamacoes).combustiveis(combustiveis).build();
	}
}
