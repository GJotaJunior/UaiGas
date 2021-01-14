package com.uai.uaigas.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uai.uaigas.entities.enums.PostoStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
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
	
	@OneToOne(mappedBy = "posto", cascade = CascadeType.ALL)
	private Endereco endereco;
	
	@JsonIgnore
	@Builder.Default
	@OneToMany(mappedBy = "posto")
	private List<Reclamacao> reclamacoes = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "posto")
	@Builder.Default
	private List<CombustivelPosto> combustiveis = new ArrayList<>();
	
	public Posto(Long id, String descricao, PostoStatus status) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.status = status;
	}
}
