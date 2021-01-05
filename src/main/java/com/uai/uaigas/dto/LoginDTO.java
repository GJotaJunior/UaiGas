package com.uai.uaigas.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Preenchimento obrigatorio")
    private String email;
    @NotBlank(message = "Preenchimento obrigatorio")
    private String senha;
}
