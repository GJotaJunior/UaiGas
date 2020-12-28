package com.uai.uaigas.dto;

import java.io.Serializable;

import com.uai.uaigas.entities.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String email;
    private String fotoUrl;

    public UsuarioDTO(Usuario usuario) {
	this.id = usuario.getId();
	this.nome = usuario.getNome();
	this.email = usuario.getEmail();
	this.fotoUrl = usuario.getFotoUrl();
    }

    public Usuario toEntity() {
	return Usuario.builder().id(id).nome(nome).email(email).fotoUrl(fotoUrl).build();
    }
}
