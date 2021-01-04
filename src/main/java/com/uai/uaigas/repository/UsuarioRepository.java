package com.uai.uaigas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.uai.uaigas.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Transactional(readOnly = true)
    Usuario findByEmail(String email);
    
    Optional<Usuario> findByEmailAndSenha(String email, String senha);

}
