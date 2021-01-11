package com.uai.uaigas.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tb_combustivel_posto")
public class CombustivelPosto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "tipo_combustivel_id")
	private TipoCombustivel tipo;

	@ManyToOne
	@JoinColumn(name = "combustivel_id")
	private Combustivel combustivel;

	@ManyToOne
    @JoinColumn(name = "posto_id")
    private Posto posto;

	@JsonIgnore
	@OneToMany(mappedBy = "combustivelPosto")
	@Builder.Default
	private List<Cotacao> cotacoes = new ArrayList<>();

}
