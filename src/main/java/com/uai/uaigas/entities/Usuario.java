package com.uai.uaigas.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uai.uaigas.entities.enums.PerfilEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String email;
    @JsonIgnore
    private String senha;
    private String fotoUrl;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PERFIS")
    private Set<Integer> perfis = new HashSet<>();

    public Usuario() {
	addPerfil(PerfilEnum.CLIENTE);
    }

    public Usuario(Long id, String nome, String email, String senha, String fotoUrl) {
	this.id = id;
	this.nome = nome;
	this.email = email;
	this.senha = senha;
	this.fotoUrl = fotoUrl;
	addPerfil(PerfilEnum.CLIENTE);
    }

    public void addPerfil(PerfilEnum perfil) {
	perfis.add(perfil.getCod());
    }

    public Set<PerfilEnum> getPerfis() {
	return perfis.stream().map(x -> PerfilEnum.toEnum(x)).collect(Collectors.toSet());
    }

}
