package com.uai.uaigas.dto;

import javax.validation.constraints.NotBlank;

import com.uai.uaigas.entities.Usuario;

import lombok.Getter;
import lombok.Setter;

public class UsuarioInsertDTO extends UsuarioDTO {

    public UsuarioInsertDTO(Long id, String nome, String email, String fotoUrl, boolean admin, String senha) {
	super(id, nome, email, fotoUrl, admin);
	this.senha = senha;
    }

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    @NotBlank(message = "Preenchimento obrigatorio")
    private String senha;

    public Usuario toEntity() {
	return Usuario.builder().id(getId()).nome(getNome()).email(getEmail()).fotoUrl(null).senha(senha).build();
    }

}
