package com.uai.uaigas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uai.uaigas.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
