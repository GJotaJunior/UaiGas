package com.uai.uaigas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uai.uaigas.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);
    
    Optional<Usuario> findByEmailAndSenha(String email, String senha);

}
