package com.uai.uaigas.dto;

import com.uai.uaigas.entities.Endereco;
import com.uai.uaigas.entities.Posto;
import com.uai.uaigas.entities.enums.PostoStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostoDTO {
	private Long id;
	private String descricao;
	private PostoStatus status;
	private Endereco endereco;
//	private List<Reclamacao> reclamacoes;
//	private List<Combustivel> combustiveis;

	public PostoDTO(Posto posto) {
		this.id = posto.getId();
		this.descricao = posto.getDescricao();
		this.status = posto.getStatus();
		this.endereco = posto.getEndereco();
//		this.reclamacoes = posto.getReclamacoes();
//		this.combustiveis = posto.getCombustiveis();
	}

	public Posto toEntity() {
		return Posto.builder().id(id).descricao(descricao).status(status).endereco(endereco).build();
	}
}
