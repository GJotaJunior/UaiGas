package com.uai.uaigas.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.uai.uaigas.entities.Endereco;
import com.uai.uaigas.entities.Posto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EnderecoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	@NotBlank(message = "Preenchimento obrigatorio")
	private String logradouro;
	private Integer numero;
	private String complemento;
	@NotBlank(message = "Preenchimento obrigatorio")
	private String bairro;
	@NotBlank(message = "Preenchimento obrigatorio")
	private String cidade;
	@NotBlank(message = "Preenchimento obrigatorio")
	private String estado;
	@NotBlank(message = "Preenchimento obrigatorio")
	private String cep;
	private Float latitude;
	private Float longitude;
	@NotNull
	private Posto posto;
	

	public EnderecoDTO(Endereco endereco) {
		this.id = endereco.getId();
		this.logradouro = endereco.getLogradouro();
		this.numero = endereco.getNumero();
		this.complemento = endereco.getComplemento();
		this.bairro = endereco.getBairro();
		this.estado = endereco.getEstado();
		this.cep = endereco.getCep();
		this.latitude = endereco.getLatitude();
		this.longitude = endereco.getLongitude();
		this.posto = endereco.getPosto();
		this.cidade = endereco.getCidade().toUpperCase();
	}

	public Endereco toEntity() {
		return Endereco.builder().id(id).logradouro(logradouro).numero(numero).complemento(complemento).bairro(bairro).estado(estado).cep(cep).latitude(latitude).longitude(longitude).posto(posto).cidade(cidade).build();
	}
}
