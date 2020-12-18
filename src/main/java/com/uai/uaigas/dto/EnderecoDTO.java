package com.uai.uaigas.dto;

import java.io.Serializable;

import com.uai.uaigas.entities.Endereco;
import com.uai.uaigas.entities.Posto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EnderecoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String logradouro;
	private Integer numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private Float latitude;
	private Float longitude;
	private Posto posto;
	

	public EnderecoDTO(Endereco endereco) {
		this.id = endereco.getId();
		this.logradouro = endereco.getLogradouro();
		this.numero = endereco.getNumero();
		this.bairro = endereco.getBairro();
		this.estado = endereco.getEstado();
		this.cep = endereco.getCep();
		this.latitude = endereco.getLatitude();
		this.longitude = endereco.getLongitude();
		this.posto = endereco.getPosto();
	}

	public Endereco toEntity() {
		return Endereco.builder().id(id).logradouro(logradouro).numero(numero).bairro(bairro).estado(estado).cep(cep).latitude(latitude).longitude(longitude).posto(posto).build();
	}
}
