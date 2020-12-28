package com.uai.uaigas.dto;

import com.uai.uaigas.entities.Usuario;

import lombok.Getter;
import lombok.Setter;

public class UsuarioInsertDTO extends UsuarioDTO {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String senha;

    public UsuarioInsertDTO(Usuario usuario) {
	super(usuario);
	this.senha = usuario.getSenha();
    }

    public UsuarioInsertDTO(Long id, String nome, String email, String fotoUrl, boolean admin, String senha) {
	super(id, nome, email, fotoUrl);
	this.senha = senha;
    }

    @Override
    public Usuario toEntity() {
	return Usuario.builder().id(getId()).nome(getNome()).email(getEmail()).fotoUrl(getFotoUrl()).senha(senha)
		.build();
    }

}
