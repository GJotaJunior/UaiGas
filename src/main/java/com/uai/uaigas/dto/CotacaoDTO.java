package com.uai.uaigas.dto;

import java.util.Calendar;

import javax.validation.constraints.NotNull;

import com.uai.uaigas.entities.Combustivel;
import com.uai.uaigas.entities.Cotacao;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CotacaoDTO {

    private Long id;
    @NotNull
    private Double preco;
    @NotNull
    private Calendar dataHora;
    @NotNull
    private Combustivel combustivel;

    public CotacaoDTO(Cotacao cotacao) {
	this.id = cotacao.getId();
	this.preco = cotacao.getPreco();
	this.dataHora = cotacao.getDataHora();
	this.combustivel = cotacao.getCombustivel();
    }

    public Cotacao toEntity() {
	return Cotacao.builder().id(id).preco(preco).dataHora(dataHora).combustivel(combustivel).build();
    }

}
