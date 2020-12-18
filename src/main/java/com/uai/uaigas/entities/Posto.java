package com.uai.uaigas.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.uai.uaigas.entities.enums.PostoStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tb_posto")
public class Posto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private PostoStatus status;
	private Endereco endereco;
	
//	@ManyToOne
//	@JoinColumn(name = "reclamacao_id")
//	private List<Reclamacao> reclamacoes;
//	
//	@ManyToOne
//	@JoinColumn(name = "combustiveis_id")
//	private List<Combustivel> combustiveis;

}
