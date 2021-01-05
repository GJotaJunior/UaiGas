package com.uai.uaigas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uai.uaigas.entities.Reclamacao;

@Repository
public interface ReclamacaoRepository extends JpaRepository<Reclamacao, Long> {

}
