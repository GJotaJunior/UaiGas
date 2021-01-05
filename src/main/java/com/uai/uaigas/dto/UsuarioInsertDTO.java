package com.uai.uaigas.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.uai.uaigas.entities.Usuario;

import lombok.Data;

@Data
public class UsuarioInsertDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    @NotBlank(message = "Preenchimento obrigatorio")
    @Length(min = 5, max = 60, message = "O campo deve ter entre 5 e 60 caracteres")
    private String nome;
    @NotBlank(message = "Preenchimento obrigatorio")
    private String email;
    @NotBlank(message = "Preenchimento obrigatorio")
    private String senha;

    public Usuario toEntity() {
	return Usuario.builder().id(id).nome(nome).email(email).fotoUrl(null).senha(senha).build();
    }

}
