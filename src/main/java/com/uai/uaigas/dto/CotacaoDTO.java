package com.uai.uaigas.dto;

import java.util.Calendar;

import com.uai.uaigas.entities.Combustivel;
import com.uai.uaigas.entities.Cotacao;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CotacaoDTO {

    private Long id;
    private Double preco;
    private Calendar dataHora;
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
